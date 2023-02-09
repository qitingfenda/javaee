package com.base.test.dao;

import com.base.test.model.po.TestPo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 目标模块持久层
 *
 * @author yhc
 * @create 2023-02-09 9:49
 */
@Repository
public interface TestDao {
    /**
     * 插入
     *
     * @param record 业务模型
     */
    void insert(TestPo record);

    /**
     * 通过id获取
     *
     * @param id id
     * @return 业务模型
     */
    TestPo getById(@Param("id") String id);

    /**
     * 修改
     *
     * @param record 业务模型
     */
    void update(TestPo record);

    /**
     * 修改非空
     *
     * @param record 业务模型
     */
    void updateNotNull(TestPo record);

    /**
     * 通过id删除
     *
     * @param id     id
     * @param delPer 删除人
     */
    void delById(@Param("id") String id,
                 @Param("delPer") String delPer);
}