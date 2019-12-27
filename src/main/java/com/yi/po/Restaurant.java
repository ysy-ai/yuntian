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
     * 餐馆图片
     */
    private String url;
    /**
     * 人均价格
     */
    private Double perprice;

    public Restaurant(){}

    public Restaurant(int id, String rname, int score, int commentcount, String address, String url) {
        this.id = id;
        this.rname = rname;
        this.score = score;
        this.commentcount = commentcount;
        this.address = address;
        this.url = url;
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

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", rname='" + rname + '\'' +
                ", score=" + score +
                ", commentcount=" + commentcount +
                ", address='" + address + '\'' +
                ", url='" + url + '\'' +
                ", perprice=" + perprice +
                '}';
    }
}
