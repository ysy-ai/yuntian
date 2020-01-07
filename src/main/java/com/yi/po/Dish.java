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

    public Dish(){}

    public Dish(int id, String dishName, int price, String pictureUrl) {
        this.id = id;
        this.dishName = dishName;
        this.price = price;
        this.pictureUrl = pictureUrl;
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

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", dishName='" + dishName + '\'' +
                ", price=" + price +
                ", pictureUrl='" + pictureUrl + '\'' +
                '}';
    }
}
