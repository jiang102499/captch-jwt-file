package com.example.request;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/12/12
 * Description: com.example.request
 * version: 1.0
 */

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *@ClassName FileRequest
 *
 *@Author lenovo
 *@Date 2020/12/12 10:06
 *description FileRequest
 **/
@Data
@NoArgsConstructor
@ApiModel("上传文件属性类")
public class FileRequest {

  @ApiModelProperty("文件名")
  private String name;

  @ApiModelProperty("文件类型")
  private String type;

  @ApiModelProperty("文件路径")
  private String path;
}
