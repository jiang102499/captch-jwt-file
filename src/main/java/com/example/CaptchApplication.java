package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaAuditing
@EnableTransactionManagement//启动注解事务管理
@EnableScheduling//启动注解定时任务
public class CaptchApplication {

  public static void main(String[] args) {
    SpringApplication.run(CaptchApplication.class, args);
  }

}
