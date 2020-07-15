package com.base.code.enumtest;

/**
 * @author yhc
 * @date 2019-08-26 10:20
 */
public enum EnumSeason implements EnumInteface {
    /**
     * 1.提供当前枚举类的对象，多个对象用逗号隔开，末尾对象用分号接收
     */
    SPRING("春天", "春暖花开") {
        @Override
        public void show() {

        }
    },
    SUMMER("夏天", "夏日炎炎") {
        @Override
        public void show() {

        }
    },
    AUTUMN("秋天", "秋高气爽") {
        @Override
        public void show() {

        }
    },
    WINTER("冬天", "冬天雪地") {
        @Override
        public void show() {

        }
    },;

    private final String seasonName;
    private final String seasonDesc;

    EnumSeason(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public void show() {

    }
}

