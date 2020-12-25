package com.example.request;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/12/3
 * Description: com.example.entity
 * version: 1.0
 */

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
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
@ApiModel("注册传参实体类")
public class RegisterRequest {

  /**
   * 用户名
   */
  @ApiModelProperty("用户名")
  @Size(min = 1,max = 30,message = "用户名长度1-30")
  @NotBlank(message = "用户名不能为空")
  private String account;

  /**
   * 用户密码
   */
  @ApiModelProperty("用户密码")
  @NotBlank(message = "密码不能为空")
  private String password;


  @ApiModelProperty(name = "验证码id")
  private String pictureId;

  @ApiModelProperty("验证码的值")
  private String code;

}
