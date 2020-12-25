package com.example.controller;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/12/12
 * Description: com.example.controller
 * version: 1.0
 */

import com.example.response.FileVO;
import com.example.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *@ClassName FileController
 *
 *@Author lenovo
 *@Date 2020/12/12 10:52
 *description FileController
 **/
@RestController
@Api(tags = "文件管理" )
@Slf4j
public class FileController {

  @Autowired
  private FileService fileService;

  @PostMapping("/upload")
  @ApiOperation(value = "上传单个文件" ,notes = "上传单个文件" ,consumes = "applicatio/json")
  public FileVO upload(MultipartFile file) throws Exception {
    log.info("上传文件-controller-开始");
    FileVO uploadFile = fileService.upload(file);
    log.info("文件上传成功");
    return uploadFile;
  }

}
