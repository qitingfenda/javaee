package com.base.test.model.po;

import lombok.Data;

import java.time.LocalDate;

/**
 * test
 * @author yhc
 */
@Data
public class TestPo {
    /**
     * 唯一id
     */
    private String id;

    /**
     * 拆分键
     */
    private String skey;

    /**
     * 创建时间
     */
    private LocalDate createTime;

    /**
     * 组织id
     */
    private String orgId;

    /**
     * 目标月份
     */
    private String goalMonth;

    /**
     * 考核日期
     */
    private String assessmentDate;

    /**
     * 考核天数
     */
    private Integer assessmentDays;

    /**
     * 是否分解(0-未分解,1-已分解)
     */
    private Integer decomposeMark;
}