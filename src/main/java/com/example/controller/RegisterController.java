package com.example.controller;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/12/3
 * Description: com.example.controller
 * version: 1.0
 */

import com.example.entity.RegisterDO;
import com.example.jwt.JwtPayLoad;
import com.example.request.RegisterRequest;
import com.example.response.RegisterVO;
import com.example.service.RegisterService;
import com.example.untils.JwtUntils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *@ClassName RegisterController
 *
 *@Author lenovo
 *@Date 2020/12/3 16:20
 *description RegisterController
 **/
@RestController
@Api(tags = "用户注册管理", description = "用户注册管理")
@Slf4j
public class RegisterController {
  @Autowired
  private RegisterService registerService;

  @Autowired
  private ModelMapper modelMapper;

  /**
   * 注册
   * @param registerRequest
   * @return
   */
  @ApiOperation("注册")
  @PostMapping("/register")
  public RegisterDO register(@Validated @RequestBody RegisterRequest registerRequest) throws Exception {
    log.info("用户注册[registerRequest{}]",registerRequest);
    RegisterDO registerDO = registerService.register(registerRequest);
    log.info("注册成功[registerDO.getId{}]",registerDO.getId());
    return registerDO;
  }


  /**
   * 登录
   * @param registerRequest
   * @return
   * @throws Exception
   */
  @ApiOperation("用户登录")
  @PostMapping("/login")
  public RegisterVO login(@Validated @RequestBody RegisterRequest registerRequest) throws Exception {
    log.info("用户登录开始");
    RegisterVO registerVO = registerService.login(registerRequest);
    JwtPayLoad payLoad = modelMapper.map(registerVO, JwtPayLoad.class);
    String token = JwtUntils.generate(payLoad);
    registerVO.setToken(token);
    log.info("登录成功");
    return registerVO;
  }
}
