package com.yi.po;

/**
 * @author yisy
 * 分页条件参数
 */
public class UtilFenye {
    private int d1;
    private int d2;
    private int pageNow;
    private String name;
    private String sign;

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

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "UtilFenye{" +
                "d1=" + d1 +
                ", d2=" + d2 +
                ", pageNow=" + pageNow +
                ", name='" + name + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
