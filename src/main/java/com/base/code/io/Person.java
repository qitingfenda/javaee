package com.base.code.io;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author yhc
 * @date 2019-12-06 10:19
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
class Person implements Serializable {

    static final long serialVersionUID = 42L;

    private Integer age;
    private String name;
}
