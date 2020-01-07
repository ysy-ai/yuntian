package com.yi.service;

import com.yi.po.Comment;
import com.yi.po.Dish;
import com.yi.po.Order;
import com.yi.po.Restaurant;

import java.util.List;

/**
 * @author yisy
 */
public interface RestaurantService {
    /**
     * 餐馆注册
     * @param restaurant 餐馆实体类
     */
    void insertRestauart(Restaurant restaurant);
    /**
     * 菜品展示
     * @param rname 餐馆名称
     * @return Dish 菜品实体类
     */
    List<Dish> selectDish(String rname);
    /**
     * 菜品单价
     * @param dishname 菜品名称
     * @return int 单价
     */
    int selectDishPrice(String dishname);
    /**
     * 订单管理  绑定用户账号
     * @param order 用户账号
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
     * 订单數量
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
     * 添加评论
     * @param comment 评论实体类
     */
    void insertComment(Comment comment);
    /**
     * 展示评论
     * @return Comment 评论实体类
     */
    List<Comment> selectComment(String restaurantname);
    /**
     * 统计评论数量
     * @param restaurantname 餐馆名称
     * @return int
     */
    int selectCountComment(String restaurantname);
}
