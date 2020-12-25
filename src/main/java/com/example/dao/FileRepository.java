package com.example.dao;

import com.example.entity.FileDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/12/12
 * Description: com.example.dao
 * version: 1.0
 */
@Repository
public interface FileRepository extends JpaRepository<FileDO,String>,JpaSpecificationExecutor<FileDO> {
}
