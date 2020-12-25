package com.example.dao;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/11/27
 * Description: com.example.dao
 * version: 1.0
 */

import com.example.entity.PictureValidationCodeDO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 *@ClassName PictureValidationCodeRepository
 *@Description 图片验证码
 *@Author lenovo
 *@Date 2020/11/27 10:55
 *@Version 1.0
 **/
public interface PictureValidationCodeRepository extends QuerydslPredicateExecutor<PictureValidationCodeDO>, JpaRepository<PictureValidationCodeDO,String>, JpaSpecificationExecutor<PictureValidationCodeDO> {
}
