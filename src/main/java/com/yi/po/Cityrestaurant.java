package com.yi.po;

/**
 * @author yisy
 * @date 2020/02/23
 */
public class Cityrestaurant {
    private int id;
    private int cityid;
    private int restaurantid;

    public Cityrestaurant(){}

    public Cityrestaurant(int id, int cityid, int restaurantid) {
        this.id = id;
        this.cityid = cityid;
        this.restaurantid = restaurantid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public int getRestaurantid() {
        return restaurantid;
    }

    public void setRestaurantid(int restaurantid) {
        this.restaurantid = restaurantid;
    }

    @Override
    public String toString() {
        return "Cityrestaurant{" +
                "id=" + id +
                ", cityid=" + cityid +
                ", restaurantid=" + restaurantid +
                '}';
    }
}
