package com.example.service;

import com.example.request.PictureValidationCheckRequest;
import com.example.response.PictureValidationVO;
import org.springframework.stereotype.Service;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/11/27
 * Description: 图片验证码接口
 * version: 1.0
 */

public interface PictureValidationCodeService {

  /**
   * 生成验证码
   * @return
   */
  PictureValidationVO generate() throws Exception;


  /**
   * 校验验证码
   * @param checkRequest
   */
  void validate(PictureValidationCheckRequest checkRequest) throws Exception;
}
