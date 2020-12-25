package com.example.controller;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/11/27
 * Description: com.example.controller
 * version: 1.0
 */

import com.example.request.PictureValidationCheckRequest;
import com.example.response.PictureValidationVO;
import com.example.service.PictureValidationCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import javax.websocket.OnError;

/**
 *@ClassName PictureValidationCodeController
 *
 *@Author lenovo
 *@Date 2020/11/27 11:10
 *description PictureValidationCodeController
 **/
@RestController
@Slf4j
@Api(tags = "图片验证码管理", description = "图片验证码管理")
public class PictureValidationCodeController {

  @Autowired
  private PictureValidationCodeService pictureValidationCodeService;


  /**
   * 生成图片验证码
   * @return
   */
  @ApiOperation("生成图片验证码")
  @GetMapping("/generate")
  public PictureValidationVO generate() throws Exception {
    log.info("生成图片验证码开始" );
    PictureValidationVO pictureValidationVO = pictureValidationCodeService.generate();
    log.info("生成验证码成功");
    return pictureValidationVO;
  }


  /**
   * 校验验证码
   * @param checkRequest
   * @throws Exception
   */
  @ApiOperation("校验验证码")
  @PostMapping("/validate")
  public void validate(PictureValidationCheckRequest checkRequest) throws Exception {
    log.info("校验验证码开始");
    pictureValidationCodeService.validate(checkRequest);
    log.info("校验验证码成功");
  }
}
