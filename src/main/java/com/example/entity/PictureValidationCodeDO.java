package com.example.entity;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/11/27
 * Description: com.example.entity
 * version: 1.0
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 *@ClassName PictureValidationCodeDO
 *
 *@Author jiangjinhua
 *@Date 2020/11/27 10:50
 *description:图片验证码实体
 **/
@Data
@Entity
@Table(name = "picture")
@EntityListeners(AuditingEntityListener.class)//时间标签，写了它，CreatedDate才能起作用
public class PictureValidationCodeDO {

  /**
   * 主键
   */
  @Id
  @GenericGenerator(name = "system-uuid",strategy = "uuid")
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
  @Column(length = 50,name = "id")
  private String id;

  /**
   * 创建时间
   */
  @CreatedDate
  @Column(nullable = false, updatable = false, name = "create_date" ,columnDefinition = "datetime COMMENT '创建时间'")
  private Date createDate;

  /**
   * 验证码
   */
  @Column(name = "code", columnDefinition = "varchar(50) comment '验证码' ")
  private String code;

}
