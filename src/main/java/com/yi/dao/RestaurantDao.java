package com.yi.dao;

import com.yi.po.*;

import java.util.List;

/**
 * @author yisy
 */

public interface RestaurantDao {
    /**
     * 菜品展示
     * @param rname 餐馆名称
     * @return Dish 菜品实体类
     */
    List<Dish> selectDish(String rname);
    List<Dish> selectDishe(String rname);
    /**
     * 菜品单价
     * @param dishname 菜品名称
     * @return int 单价
     */
    int selectDishPrice(String dishname);
    /**
     * 订单管理  绑定用户账号
     * @param order 订单实体类
     */
    void insertOrder(Order order);
    /**
     * 订单详情
     * @param order 订单实体类
     * @return Order 订单实体类
     */
    Order selectOrder(Order order);
    /**
     * 订单數量
     * @param order 订单实体类
     * @return int 订单數量
     */
    int selectCountOrder(Order order);
    /**
     * 订单id
     * @param order 订单实体类
     * @return int
     */
    int selectOrderid(Order order);
    /**
     * 删除订单
     * @param id 订单id
     */
    void deleteOrder(int id);
    /**
     * 删除支付状态为0的订单
     */
    void deleteOrderStatus();
    /**
     * 更新订单状态
     * @param order 订单实体类
     */
    void updateStatus(Order order);
    /**
     * 查询全部订单
     * @param order 订单实体类
     * @return Order
     */
    List<Order> selectAllOrder(Order order);
    /**
     * 删除顶单
     * @param order 订单实体类
     */
    void deleteOrderbyTime(Order order);
    /**
     * 添加评论
     * @param comment 评论实体类
     */
    void insertComment(Comment comment);
    /**
     * 展示评论
     * @param restaurantname 餐馆名称
     * @return Comment 评论实体类
     */
    List<Comment> selectComment(String restaurantname);
    /**
     * 统计评论数量
     * @param restaurantname 餐馆名称
     * @return int
     */
    int selectCountComment(String restaurantname);

    /**
     * 商家中心
     */
    /**
     * 商家注册
     * @param restaurant 餐馆实体类
     */
    void insertRestauart(Restaurant restaurant);
    /**
     * 根据所在城市查询城市id
     * @return int
     * @param cityname 城市名称
     */
    int selectIdbycityname(String cityname);
    /**
     * 查询新注册餐馆id
     * @return int
     */
    int selectLastRestaurant();
    /**
     * 城市餐馆表新增
     * @param cityrestaurant 城市餐馆实体类
     */
    void insertCityrestaurant(Cityrestaurant cityrestaurant);
    /**
     * 商家详情
     * @param tel
     * @return Restauart 餐馆实体类
     */
    List<Restaurant> selectRestaurantbytel(String tel);
    /**
     * 注销餐馆
     * @param id 餐馆id
     */
    void deletecityRestaurantbyrid(int id);
    void deletedishRestaurantbyrid(int id);
    void deleteRestaurant(int id);
    /**
     * 上架、下架
     * @param dish
     */
    void updateDishStatus(Dish dish);
    /**
     * 删除评论
     * @param id
     */
    void deleteCommentbyId(int id);
    /**
     * 新菜上架
     * @param dish 菜品实体类
     */
    void insertDish(Dish dish);
    /**
     * 查询菜品所在餐馆id
     * @param rname
     * @return int
     */
    int selectIdbyrname(String rname);
    /**
     * 查询新增菜品id
     * @return int
     */
    int selectLastDish();
    /**
     * 菜品餐馆表新增
     * @param dishrestaurant
     */
    void insertDishRestaurant(Dishrestaurant dishrestaurant);
}
