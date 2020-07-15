package com.base.code.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author yhc
 * @date 2019-08-21 9:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Goods implements Comparable {
    private String name;
    private double price;

    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods goods = (Goods) o;
            if (this.price > goods.price) {
                return 1;
            } else if (this.price < goods.price) {
                return -1;
            } else {
                return this.name.compareTo(goods.name);
            }
        }
        throw new RuntimeException("传入的数据类型不一致");
    }
}
