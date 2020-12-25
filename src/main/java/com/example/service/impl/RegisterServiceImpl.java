package com.example.service.impl;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/12/3
 * Description: com.example.service.impl
 * version: 1.0
 */

import com.example.dao.PictureValidationCodeRepository;
import com.example.dao.RegisterRepository;
import com.example.entity.RegisterDO;
import com.example.request.PictureValidationCheckRequest;
import com.example.request.RegisterRequest;
import com.example.response.RegisterVO;
import com.example.service.PictureValidationCodeService;
import com.example.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.validation.constraints.Size;

/**
 *@ClassName RegisterServiceImpl
 *
 *@Author lenovo
 *@Date 2020/12/3 16:03
 *description RegisterServiceImpl
 **/
@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {

  @Autowired
  private RegisterRepository registerRepository;

  @Autowired
  private PictureValidationCodeService pictureValidationCodeService;

  @Autowired
  private ModelMapper modelMapper;

  /**
   * 注册
   * @param registerRequest
   * @return
   * @throws Exception
   */
  @Override
  public RegisterDO register(RegisterRequest registerRequest) throws Exception {
    log.info("用户注册-service-开始[regusterRequest{}]",registerRequest);
    RegisterDO registerDO = new RegisterDO();
    registerDO.setAccount(registerRequest.getAccount());
    registerDO.setPassword(registerRequest.getPassword());

    //校验验证码
    PictureValidationCheckRequest pictureValidationCheckRequest = new PictureValidationCheckRequest();

    pictureValidationCheckRequest.setId(registerRequest.getPictureId());
    pictureValidationCheckRequest.setCode(registerRequest.getCode());
    pictureValidationCodeService.validate(pictureValidationCheckRequest);


    RegisterDO save = registerRepository.save(registerDO);
    log.info("用户注册-service-结束");
    return save;
  }

  /**
   * 登录
   * @param registerRequest
   * @return
   * @throws Exception
   */
  @Override
  public RegisterVO login(RegisterRequest registerRequest) throws Exception {
    log.info("用户登录-servce-开始[registerRequest{}]",registerRequest);
    RegisterDO registerDO = registerRepository.findByAccountAndPassword(registerRequest.getAccount(), registerRequest.getPassword());
    RegisterVO registerVO = modelMapper.map(registerDO, RegisterVO.class);
    //校验验证码
    PictureValidationCheckRequest pictureValidationCheckRequest = new PictureValidationCheckRequest();
    pictureValidationCheckRequest.setId(registerRequest.getPictureId());
    pictureValidationCheckRequest.setCode(registerRequest.getCode());
    pictureValidationCodeService.validate(pictureValidationCheckRequest);

    log.info("用户登录-servicce-结束[registerRequest.account{}]",registerRequest.getAccount());
    return registerVO;
  }
}
