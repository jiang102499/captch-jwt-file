package com.example.service.impl;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/12/12
 * Description: com.example.service.impl
 * version: 1.0
 */

import com.example.dao.FileRepository;
import com.example.entity.FileDO;
import com.example.request.FileRequest;
import com.example.response.FileVO;
import com.example.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.reflections.vfs.Vfs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 *@ClassName FileServiceImpl
 *
 *@Author lenovo
 *@Date 2020/12/12 10:10
 *description FileServiceImpl
 **/

@Service
@Slf4j
public class FileServiceImpl implements FileService {

  @Autowired
  private FileRepository fileRepository;

  @Autowired
  private ModelMapper modelMapper;

  /**
   * 上传文件
   * @param file
   * @return
   */
  @Override
  public FileVO upload(MultipartFile file) throws Exception {
    log.info("上传文件-service-开始");
    //判断上传文件是否为空
    if (file.isEmpty()){
      throw new Exception("上传文件为空");
    }
    //封装文件
    FileVO fileVO = getInfo(file);
    //校验文件的类型
    if (!fileVO.getOriginalName().substring(fileVO.getOriginalName().lastIndexOf(".")).substring(1).equals("png")){
      throw new Exception("文件类型不正确");
    }
    //保持文件
    File path = new File(fileVO.getPath());
    //文件夹
    File parentFile = path.getParentFile();
    //判断文件夹是否存在
    if (!parentFile.exists()){
      //不存在就创建
      parentFile.mkdirs();
    }
    //将文件写入磁盘
    file.transferTo(path);
    //文件信息保存到数据库中
    FileVO saveFile = saveFile(fileVO);
    log.debug("文件上传-service-结束：[saveFile:{}]", saveFile);

    //将文件信息保存到数据库中
    return saveFile;
  }


  /**
   * 封装文件
   * @param file
   * @return
   */
  public FileVO getInfo(MultipartFile file){
    //获取文件名称
    String originalFilename = file.getOriginalFilename();
    //获取文件后缀名
    String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
    //获取文件类型
    String type = ext.substring(1);
    //获取文件大小
    long size = file.getSize();

    //获取一个uuid
    String uuid = UUID.randomUUID().toString().replace("-", "");

    //创建路径
    String prefixPath="D:\\working\\upload\\";

    //创建文件名 uuid + 文件后缀名
    String storeName=uuid + ext;

    //该文件最终路径
    String finalPath=prefixPath + storeName;

    //赋值
    FileVO fileVO=new FileVO();

    fileVO.setPath(finalPath);
    fileVO.setOriginalName(originalFilename);
    fileVO.setName(storeName);

    return fileVO;
  }


  /**
   * 将文件信息保存到数据库中
   * @param fileVO
   * @return
   */
  public FileVO saveFile(FileVO fileVO){
    FileDO fileDO = modelMapper.map(fileVO, FileDO.class);
    fileDO.setType("png");
    FileDO save = fileRepository.save(fileDO);
    FileVO fileVO1 = modelMapper.map(fileDO, FileVO.class);
    return fileVO1;
  }


}
