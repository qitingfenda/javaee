package com.base.test.service.impl;

import com.base.test.dao.TestDao;
import com.base.test.model.po.TestPo;
import com.base.test.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 供应商基础配置表(CrmSupplierConfig)表服务实现类
 *
 * @author makejava
 * @since 2023-12-18 16:28:29
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestDao testDao;

    @Override
    public TestPo getById(String id) {
        return this.testDao.getById(id);
    }

    @Override
    public void insert(TestPo testPo) {
        this.testDao.insert(testPo);
    }

    @Override
    public void update(TestPo testPo) {
        this.testDao.update(testPo);
    }

    @Override
    public void updateNotNull(TestPo testPo) {
        this.testDao.updateNotNull(testPo);
    }

    @Override
    public void deleteById(String id, String delPer) {
        testDao.delById(id, delPer);
    }
}
