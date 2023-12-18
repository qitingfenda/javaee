package com.base.test.service;

import com.base.test.model.po.TestPo;

/**
 * 供应商基础配置表(CrmSupplierConfig)表服务接口
 *
 * @author makejava
 * @since 2023-12-18 16:28:27
 */
public interface TestService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TestPo getById(String id);

    /**
     * 新增数据
     *
     * @param TestPo 实例对象
     */
    void insert(TestPo TestPo);

    /**
     * 修改数据
     *
     * @param TestPo 实例对象
     */
    void update(TestPo TestPo);

    /**
     * 修改数据
     *
     * @param TestPo 实例对象
     */
    void updateNotNull(TestPo TestPo);

    /**
     * 通过主键删除数据
     */
    void deleteById(String id, String delPer);
}
