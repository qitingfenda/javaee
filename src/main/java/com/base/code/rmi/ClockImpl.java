package com.base.code.rmi;

import java.time.LocalDate;

/**
 * @author yhc
 * @create 2021-02-23 14:47
 */
public class ClockImpl implements Clock {

    @Override
    public LocalDate currentTime() {
        return LocalDate.now();
    }
}
