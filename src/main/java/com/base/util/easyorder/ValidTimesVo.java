package com.base.util.easyorder;

import lombok.Data;

/**
 * @author yhc
 * @create 2024-01-11 14:34
 */
@Data
public class ValidTimesVo {
    /**
     * 次数
     */
    private String number;
    /**
     * 值
     */
    private Integer value;

    public ValidTimesVo(String number) {
        this.number = number;
        this.value = 0;
    }

    public ValidTimesVo(String number, Integer value) {
        this.number = number;
        this.value = value;
    }

    public ValidTimesVo(int number) {
        this(number + "");
    }
}
