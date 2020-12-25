package com.example.response;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/12/3
 * Description: com.example.entity
 * version: 1.0
 */

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *@ClassName RegisterDO
 *
 *@Author lenovo
 *@Date 2020/12/3 15:37
 *description 注册实体类
 **/
@Data
@Api("注册返回实体类")
public class RegisterVO {

  /**
   * id（uuid）
   */
  @ApiModelProperty("id")
  private String id;

  /**
   * 用户名
   */
  @ApiModelProperty("用户名")
  private String account;

  /**
   * 用户密码
   */
  @ApiModelProperty("用户密码")
  private String password;

  /**
   * token
   */
  @ApiModelProperty("token")
  private String token;
}
