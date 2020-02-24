package com.yi.po;

/**
 * @author yisy
 * 菜品实体类
 */
public class Dish {
    private int id;
    /**
     * 菜品名称
     */
    private String dishName;
    /**
     * 菜品名称
     */
    private int price;
    /**
     * 菜品图片路径
     */
    private String pictureUrl;
    /**
     * 菜品状态
     */
    private int status;
    private String statusDetails;
    private String rname;

    public Dish(){}

    public Dish(int id, String dishName, int price, String pictureUrl, int status, String statusDetails, String rname) {
        this.id = id;
        this.dishName = dishName;
        this.price = price;
        this.pictureUrl = pictureUrl;
        this.status = status;
        this.statusDetails = statusDetails;
        this.rname = rname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getStatusDetails() {
        return statusDetails;
    }

    public void setStatusDetails(String statusDetails) {
        this.statusDetails = statusDetails;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", dishName='" + dishName + '\'' +
                ", price=" + price +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", status=" + status +
                ", statusDetails='" + statusDetails + '\'' +
                ", rname='" + rname + '\'' +
                '}';
    }
}
