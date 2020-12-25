package com.example.config;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/12/4
 * Description: com.example.config
 * version: 1.0
 */

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 *@ClassName ModelMapperConfig
 *
 *@Author lenovo
 *@Date 2020/12/4 10:58
 *description ModelMapperConfig
 **/
@Component
public class ModelMapperConfig {

 // ModelMapper   实例化   -- 切记配置匹配严格要求 。
  @Bean
  public ModelMapper modelMapper(){
    ModelMapper modelMapper =  new ModelMapper();
    modelMapper.getConfiguration().setFullTypeMatchingRequired(true);
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    return modelMapper;
  }
}
