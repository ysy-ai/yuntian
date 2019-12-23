package com.yi.po;

public class UtilFenye {
    private int d1;
    private int d2;
    private int pageNow;
    private String name;

    public int getD1() {
        return d1;
    }

    public void setD1(int d1) {
        this.d1 = d1;
    }

    public int getD2() {
        return d2;
    }

    public void setD2(int d2) {
        this.d2 = d2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    @Override
    public String toString() {
        return "UtilFenye{" +
                "d1=" + d1 +
                ", d2=" + d2 +
                ", name='" + name + '\'' +
                '}';
    }
}
