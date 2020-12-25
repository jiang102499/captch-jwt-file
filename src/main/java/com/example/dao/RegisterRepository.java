package com.example.dao;

import com.example.entity.PictureValidationCodeDO;
import com.example.entity.RegisterDO;
import com.example.response.RegisterVO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/12/3
 * Description: 注册
 * version: 1.0
 */
public interface RegisterRepository extends QuerydslPredicateExecutor<RegisterDO>, JpaRepository<RegisterDO,String>, JpaSpecificationExecutor<RegisterDO> {

  /**
   * 根据用户名和密码登录
   * @param account
   * @param password
   * @return
   */
  RegisterDO findByAccountAndPassword(String account,String password);

}
