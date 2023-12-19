package com.base.test.service.impl;

import com.base.test.dao.TestDao;
import com.base.test.model.po.TestPo;
import com.base.test.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return testDao.getById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(TestPo testPo) {
        testDao.insert(testPo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TestPo testPo) {
        testDao.update(testPo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateNotNull(TestPo testPo) {
        testDao.updateNotNull(testPo);
    }

    @Override
    public void deleteById(String id, String delPer) {
        testDao.delById(id, delPer);
    }
}
