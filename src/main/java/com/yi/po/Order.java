package com.yi.po;

/**
 * @author yisy
 */
public class Order {
    private int id;
    /**
     * 用户账号
     */
    private String tel;
    /**
     * 项目名
     */
    private String name;
    /**
     * 下单时间
     */
    private String time;
    /**
     * 支付状态 1:未支付 2：支付
     */
    private int status;
    /**
     * 菜品图片路径
     */
    private String pictureUrl;

    public Order(){}

    public Order(int id, String tel, String name, String time, int status, String pictureUrl) {
        this.id = id;
        this.tel = tel;
        this.name = name;
        this.time = time;
        this.status = status;
        this.pictureUrl = pictureUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", tel='" + tel + '\'' +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", status=" + status +
                ", pictureUrl='" + pictureUrl + '\'' +
                '}';
    }
}
