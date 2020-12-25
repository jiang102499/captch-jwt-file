package com.example.service;

import com.example.entity.RegisterDO;
import com.example.request.RegisterRequest;
import com.example.response.RegisterVO;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/12/3
 * Description: com.example.service
 * version: 1.0
 */
public interface RegisterService {

  /**
   * 注册
   * @param registerRequest
   * @return
   */
  public RegisterDO register(RegisterRequest registerRequest) throws Exception;

  RegisterVO login(RegisterRequest registerRequest) throws Exception;
}
