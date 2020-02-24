package com.yi.po;

/**
 * @author yisy
 * @date 2020/02/24
 * 菜品餐馆实体类
 */
public class Dishrestaurant {
    private int id;
    private int dishid;
    private int restaurantid;

    public Dishrestaurant(){}

    public Dishrestaurant(int id, int dishid, int restaurantid) {
        this.id = id;
        this.dishid = dishid;
        this.restaurantid = restaurantid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDishid() {
        return dishid;
    }

    public void setDishid(int dishid) {
        this.dishid = dishid;
    }

    public int getRestaurantid() {
        return restaurantid;
    }

    public void setRestaurantid(int restaurantid) {
        this.restaurantid = restaurantid;
    }

    @Override
    public String toString() {
        return "Dishrestaurant{" +
                "id=" + id +
                ", dishid=" + dishid +
                ", restaurantid=" + restaurantid +
                '}';
    }
}
