package com.example.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletContext;
import java.util.ArrayList;

/**

 * @author :
 * @date :        2020/12/27 11:53
 * description :  swagger配置文件
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket petApi(){
    return  new Docket(DocumentationType.SWAGGER_2)
      //配置swagger信息
      .apiInfo(apiInfo())
      //配置API文档分组  想要配置多个组的话就需要多创建Docket实例
      // @Bean
      //    public Docket docket1(){
      //        return  new Docket(DocumentationType.SWAGGER_2).groupName("蒋锦华2");
      //    } 即可多一个分组
      .groupName("蒋锦华")
      //enable开启 是否启用swagger true启动 false不启动
      .select()
      //RequestHandlerSelectors扫描方式
      //basePackage扫描包
      //any全部扫描
      //none全部不扫描
      //withClassAnnotation扫描class的注解 ，参数是一个注解的反射对象 如 RestController.class
      //withMethodAnnotation扫描方法上的注解 如 GetMapper.class
      .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
      //paths过滤路径
      //ant设置过滤的路径
      //.paths(PathSelectors.ant("kuang/**"))
      .build();
  }
  //配置swagger信息的类，通过DocumentationType.SWAGGER_2.apiInfo调用这个方法
  //这些配置的大部分是没有什么用的，都是用来显示的，但是就算没用我们也要赔，因为我们点进去ApiInfo这个方法
  //我们就会发现它没有set方法，只有get方法，所以就算没用只是用来显示，我们也要将其配置好，就算是乱输入，也要输入
  //不然你们懂的
  public ApiInfo apiInfo(){
    Contact contact = new Contact("蒋锦华", "https://i.csdn.net/#/uc/profile", "1661259340@qq.com");
    return new ApiInfo("蒋锦华的swagger日志",
      "你尽管努力，其他的交给天意",
      "1.0",
      "https://i.csdn.net/#/uc/profile",
      contact,
      "Apache 2.0",
      "http://www.apache.org/licenses/LICENSE-2.0",
      new ArrayList());
  }






}
