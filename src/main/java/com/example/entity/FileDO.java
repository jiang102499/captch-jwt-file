package com.example.entity;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/12/12
 * Description: com.example.entity
 * version: 1.0
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 *@ClassName FileDO
 *
 *@Author lenovo
 *@Date 2020/12/12 10:04
 *description FileDO
 **/
@Data
@Entity
@Table(name = "file")
@EntityListeners(AuditingEntityListener.class)
public class FileDO {

  @Id
  @GenericGenerator(name = "system_uuid",strategy = "uuid")
  @GeneratedValue(generator = "system_uuid")
  @Column(length = 255,name = "id")
  private String id;

  /**
   * 文件名字
   */
  @Column(name = "name", nullable = false, columnDefinition = "varchar(50) comment '文件名'")
  private String name;


  /**
   * 文件原名
   */
  @Column(name = "original_name", columnDefinition = "varchar(50) comment '文件原名'")
  private String originalName;

  /**
   * 地址
   */
  @Column(name = "path", nullable = false, columnDefinition = "varchar(100) comment '地址存储路径'")
  private String path;

  /**
   * 文件类型
   */
  @Column(name = "type", nullable = false, columnDefinition = "varchar(100) comment '文件类型'")
  private String type;

}
