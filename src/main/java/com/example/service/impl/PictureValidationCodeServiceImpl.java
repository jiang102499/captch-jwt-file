package com.example.service.impl;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/11/27
 * Description: com.example.service.impl
 * version: 1.0
 */

import com.example.config.CaptchaParameterConfig;
import com.example.dao.PictureValidationCodeRepository;
import com.example.entity.PictureValidationCodeDO;
import com.example.request.PictureValidationCheckRequest;
import com.example.response.PictureValidationVO;
import com.example.service.PictureValidationCodeService;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;

/**
 *@ClassName PictureValidationCodeServiceImpl
 *
 *@Author lenovo
 *@Date 2020/11/27 11:06
 *description 图片验证码接口实现类
 **/
@Service
@Slf4j
public class PictureValidationCodeServiceImpl implements PictureValidationCodeService {

  @Autowired
  private DefaultKaptcha defaultKaptcha;

  @Autowired
  private PictureValidationCodeRepository pictureValidationCodeRepository;

  @Autowired
  private CaptchaParameterConfig parameterConfig;

  /**
   * 生成验证码
   * @return
   */
  @Override
  public PictureValidationVO generate() throws Exception {
    log.info("生成图片验证码-service-开始");

    //通过DefaultKaptcha获得随机验证码
    String text = defaultKaptcha.createText();

    //生成图片加密后Base64字符串
    String imgBase64String = getImgBase64String(text);

    //添加验证码，保存到数据库中
    PictureValidationCodeDO pictureValidationCodeDO = savePictureValidationCode(text);

    //构造图片验证码(id,code)
    PictureValidationVO pictureValidationVO = new PictureValidationVO(pictureValidationCodeDO.getId(), imgBase64String);

    log.info("生成图片验证码-service-结束[id:{}]", pictureValidationVO.getId());
    return pictureValidationVO;
  }

  /**
   * 校验验证码
   * @param checkRequest
   */
  @Override
  public void validate(PictureValidationCheckRequest checkRequest) throws Exception {
    log.debug("校验图片验证码-service-开始[checkRequest:{}]", checkRequest);

    //根据id查询验证码
    Optional<PictureValidationCodeDO> validationCodeDO = pictureValidationCodeRepository.findById(checkRequest.getId());

    //判断验证码是否存在
    if (!validationCodeDO.isPresent()){
      log.info("校验验证码失败，验证码不存在[checkRequest:{}]", checkRequest);
      throw new Exception("验证码不存在");
    }

    PictureValidationCodeDO pictureValidationCodeDO = validationCodeDO.get();
    //校验验证码是否过期
    if (System.currentTimeMillis() - pictureValidationCodeDO.getCreateDate().getTime() > parameterConfig.getValidDuration()) {
      log.info("校验验证码失败，验证码已过期[checkRequest:{}]", checkRequest);
      throw new Exception("验证码已过期");
    }
    //判断输入的验证码是否正确
    if(!pictureValidationCodeDO.getCode().equals(checkRequest.getCode())){
      log.info("验证码错误[checkRequest:{}]", checkRequest);
    }

    log.info("校验图片验证码-service-结束");

  }


  /**
   * 添加验证码（保存到数据库中）
   * @param code
   * @return
   */
  private PictureValidationCodeDO savePictureValidationCode(String code){

    PictureValidationCodeDO pictureValidationCodeDO = new PictureValidationCodeDO();
    pictureValidationCodeDO.setCode(code);
    PictureValidationCodeDO save = pictureValidationCodeRepository.save(pictureValidationCodeDO);
    return save;
  }


  /**
   * 生成图片加密后Base64字符串
   *
   * @param code
   * @return Base64字符串
   */
  private String getImgBase64String(String code) throws Exception {

  //将我们生成的随机验证码转换为图片
  //将验证码图片转换成字节流
  BufferedImage image = defaultKaptcha.createImage(code);

  //获取二进制输出流
  ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();

  try {
    ImageIO.write(image, "jpg", jpegOutputStream);
  } catch (IOException e) {
    e.printStackTrace();
    throw new Exception("验证码图片转换成字节流失败");
  }
  //返回Base64字符串
  return Base64.encodeBase64String(jpegOutputStream.toByteArray());
}


}
