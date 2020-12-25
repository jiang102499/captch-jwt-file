package com.example.service;

import com.example.response.FileVO;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/12/12
 * Description: com.example.service
 * version: 1.0
 */
public interface FileService {

  /**
   * 上传文件
   * @param file
   * @return
   */
  public FileVO upload(MultipartFile file) throws Exception;
}
