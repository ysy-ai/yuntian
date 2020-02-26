package com.yi.po;

/**
 * @author yisy
 */
public class Restaurant {
    /**
     * 主键id
     */
    private int id;
    /**
     * 餐馆名称
     */
    private String rname;
    /**
     * 评分
     */
    private int score;
    /**
     * 评论数量
     */
    private int commentcount;
    /**
     * 餐馆地址
     */
    private String address;
    /**
     * 电话
     */
    private String tel;
    /**
     * 餐馆图片
     */
    private String url;
    /**
     * 人均价格
     */
    private Double perprice;
    /**
     * 餐馆类型
     */
    private String type;

    public Restaurant(){}

    public Restaurant(int id, String rname, int score, int commentcount, String address, String tel, String url, Double perprice,String type) {
        this.id = id;
        this.rname = rname;
        this.score = score;
        this.commentcount = commentcount;
        this.address = address;
        this.tel = tel;
        this.url = url;
        this.perprice = perprice;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCommentcount() {
        return commentcount;
    }

    public void setCommentcount(int commentcount) {
        this.commentcount = commentcount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getPerprice() {
        return perprice;
    }

    public void setPerprice(Double perprice) {
        this.perprice = perprice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", rname='" + rname + '\'' +
                ", score=" + score +
                ", commentcount=" + commentcount +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", url='" + url + '\'' +
                ", perprice=" + perprice +
                ", type='" + type + '\'' +
                '}';
    }
}
