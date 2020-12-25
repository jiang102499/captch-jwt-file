package com.example.entity;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/12/3
 * Description: com.example.entity
 * version: 1.0
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 *@ClassName RegisterDO
 *
 *@Author lenovo
 *@Date 2020/12/3 15:37
 *description 注册实体类
 **/
@Data
@Entity
@Table(name = "user")
@GenericGenerator(name="system-uuid", strategy="uuid") //这个是hibernate的注解/生成32位UUID
public class RegisterDO {

  @Id//主键
  @GeneratedValue(generator="system-uuid")
  @Column(length = 30,name = "id")
  private String id;

  @Column(length = 30,name = "account",columnDefinition = "varchar(50) comment '用户账号' ")
  private String account;

  @Column(length = 30,name = "password",columnDefinition = "varchar(50) comment '用户密码' ")
  private String password;

}
