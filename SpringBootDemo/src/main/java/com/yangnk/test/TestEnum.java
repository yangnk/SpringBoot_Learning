package com.yangnk.test;

public enum TestEnum {


    SPRING(1,"春天"), SUMMER(2,"夏天");


    int index;
    String desc;

    TestEnum(int index, String desc) {
        this.index = index;
        this.desc = desc;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
