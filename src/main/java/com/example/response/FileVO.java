package com.example.response;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/12/12
 * Description: com.example.response
 * version: 1.0
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *@ClassName FileVO
 *
 *@Author lenovo
 *@Date 2020/12/12 10:05
 *description FileVO
 **/
@Data
@NoArgsConstructor
@ApiModel("上传成功后返回数据类")
public class FileVO {

  /**
   * 文件path
   */
  @ApiModelProperty("文件path")
  private String path;

  /**
   * 文件名字
   */
  @ApiModelProperty("文件名字")
  private String name;

  /**
   * 文件原名
   */
  @ApiModelProperty("文件原名")
  private String originalName;

}
