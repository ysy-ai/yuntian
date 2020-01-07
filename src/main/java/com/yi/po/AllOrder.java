package com.yi.po;

/**
 * @author yisy
 * 全部订单
 */
public class AllOrder {
    /**
     * 菜品名称
     */
    private String dishname;
    /**
     * 餐馆名称
     */
    private String rname;
    /**
     * 菜品数量
     */
    private int count;
    /**
     * 下单时间
     */
    private String time;
    /**
     * 总价
     */
    private int total;
    /**
     * 订单状态
     */
    private String status;
    /**
     * 菜品图片路径
     */
    private String pictureUrl;

    public AllOrder(){}

    public AllOrder(String dishname, String rname, int count, String time, int total, String status, String pictureUrl) {
        this.dishname = dishname;
        this.rname = rname;
        this.count = count;
        this.time = time;
        this.total = total;
        this.status = status;
        this.pictureUrl = pictureUrl;
    }

    public String getDishname() {
        return dishname;
    }

    public void setDishname(String dishname) {
        this.dishname = dishname;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
        return "AllOrder{" +
                "dishname='" + dishname + '\'' +
                ", rname='" + rname + '\'' +
                ", count=" + count +
                ", time='" + time + '\'' +
                ", total=" + total +
                ", status='" + status + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                '}';
    }
}
