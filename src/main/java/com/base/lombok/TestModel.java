package com.base.lombok;

import lombok.Builder;
import lombok.Data;

/**
 * @author yhc
 * @create 2021-03-19 13:53
 */
@Data
@Builder
public class TestModel {

    private String id;

    private String name;

    private Integer age;
}
