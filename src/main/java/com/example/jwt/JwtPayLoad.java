package com.example.jwt;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/12/4
 * Description: com.example.jwt
 * version: 1.0
 */

import lombok.Data;

/**
 *@ClassName JwpPayLoad
 *
 *@Author lenovo
 *@Date 2020/12/4 11:07
 *description jwt实体类
 **/
@Data
public class JwtPayLoad {

  /**
   * id
   */
  private String id;
  /**
   * account
   */
  private String account;
  /**
   * password
   */
  private String password;

  public JwtPayLoad(String id, String account, String password) {
    this.id = id;
    this.account = account;
    this.password = password;
  }

  public JwtPayLoad() {
  }
}
