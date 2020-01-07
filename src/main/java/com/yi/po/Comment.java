package com.yi.po;

/**
 * @author yisy
 */
public class Comment {
    private int id;
    /**
     * 评论内容
     */
    private String text;
    /**
     * 评论图片路径
     */
    private String photourl;
    /**
     * 用户头像路径
     */
    private String headurl;
    /**
     * 餐馆名称
     */
    private String restaurantname;

    public Comment(){}

    public Comment(int id, String text, String photourl, String headurl, String restaurantname) {
        this.id = id;
        this.text = text;
        this.photourl = photourl;
        this.headurl = headurl;
        this.restaurantname = restaurantname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }

    public String getHeadurl() {
        return headurl;
    }

    public void setHeadurl(String headurl) {
        this.headurl = headurl;
    }

    public String getRestaurantname() {
        return restaurantname;
    }

    public void setRestaurantname(String restaurantname) {
        this.restaurantname = restaurantname;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", photourl='" + photourl + '\'' +
                ", headurl='" + headurl + '\'' +
                ", restaurantname='" + restaurantname + '\'' +
                '}';
    }
}
