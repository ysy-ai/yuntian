package com.yi.service.impl;

import com.yi.dao.RestaurantDao;
import com.yi.po.*;
import com.yi.service.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yisy
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {
    /**
     * 自动注入
     */
    private final RestaurantDao restaurantDao;
    public RestaurantServiceImpl(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }

    /**
     * 餐馆注册
     * @param rname 餐馆名称
     */
    @Override
    public List<Dish> selectDish(String rname) {
        return restaurantDao.selectDish(rname);
    }

    @Override
    public List<Dish> selectDishe(String rname) {
        return restaurantDao.selectDishe(rname);
    }

    /**
     * 菜品单价
     * @param dishname 菜品名称
     * @return int 单价
     */
    @Override
    public int selectDishPrice(String dishname) {
        return restaurantDao.selectDishPrice(dishname);
    }

    /**
     * 订单管理  绑定用户账号
     * @param order 订单实体类
     */
    @Override
    public void insertOrder(Order order) {
        restaurantDao.insertOrder(order);
    }
    /**
     * 订单详情
     * @param order 订单实体类
     * @return Order 订单实体类
     */
    @Override
    public Order selectOrder(Order order) {
        return restaurantDao.selectOrder(order);
    }
    /**
     * 订单數量
     * @param order 订单实体类
     * @return int 订单數量
     */
    @Override
    public int selectCountOrder(Order order) {
        return restaurantDao.selectCountOrder(order);
    }
    /**
     * 订单數量
     * @param order 订单实体类
     * @return int
     */
    @Override
    public int selectOrderid(Order order) {
        return restaurantDao.selectOrderid(order);
    }
    /**
     * 订单數量
     * @param id 订单id
     */
    @Override
    public void deleteOrder(int id) {
        restaurantDao.deleteOrder(id);
    }
    /**
     * 删除支付状态为0的订单
     */
    @Override
    public void deleteOrderStatus() {
        restaurantDao.deleteOrderStatus();
    }

    /**
     * 更新订单状态
     * @param order 订单实体类
     */
    @Override
    public void updateStatus(Order order) {
        restaurantDao.updateStatus(order);
    }
    /**
     * 查询全部订单
     * @param order 订单实体类
     * @return Order
     */
    @Override
    public List<Order> selectAllOrder(Order order) {
        return restaurantDao.selectAllOrder(order);
    }
    /**
     * 添加评论
     * @param comment 评论实体类
     */
    @Override
    public void insertComment(Comment comment) {
        restaurantDao.insertComment(comment);
    }
    /**
     * 展示评论
     * @return Comment 评论实体类
     */
    @Override
    public List<Comment> selectComment(String restaurantname) {
        return restaurantDao.selectComment(restaurantname);
    }
    /**
     * 统计评论数量
     * @param restaurantname 餐馆名称
     * @return int
     */
    @Override
    public int selectCountComment(String restaurantname) {
        return restaurantDao.selectCountComment(restaurantname);
    }

    /**
     * 商家中心
     */
    /**
     * 商家注册
     * @param restaurant 餐馆实体类
     */
    @Override
    public void insertRestauart(Restaurant restaurant) {
        restaurantDao.insertRestauart(restaurant);
    }
    /**
     * 根据所在城市查询城市id
     * @return int
     * @param cityname 城市名称
     */
    @Override
    public int selectIdbycityname(String cityname) {
        return restaurantDao.selectIdbycityname(cityname);
    }
    /**
     * 查询新注册餐馆id
     * @return int
     */
    @Override
    public int selectLastRestaurant() {
        return restaurantDao.selectLastRestaurant();
    }
    /**
     * 城市餐馆表新增
     * @param cityrestaurant 城市餐馆实体类
     */
    @Override
    public void insertCityrestaurant(Cityrestaurant cityrestaurant) {
        restaurantDao.insertCityrestaurant(cityrestaurant);
    }
    /**
     * 商家详情
     * @param tel
     * @return Restauart 餐馆实体类
     */
    @Override
    public List<Restaurant> selectRestaurantbytel(String tel) {
        return restaurantDao.selectRestaurantbytel(tel);
    }
    /**
     * 上架、下架
     * @param dish
     */
    @Override
    public void updateDishStatus(Dish dish) {
        restaurantDao.updateDishStatus(dish);
    }
    /**
     * 删除评论
     * @param id
     */
    @Override
    public void deleteCommentbyId(int id) {
        restaurantDao.deleteCommentbyId(id);
    }

    /**
     * 新菜上架
     * @param dish 菜品实体类
     */
    @Override
    public void insertDish(Dish dish) {
        restaurantDao.insertDish(dish);
    }
    /**
     * 查询菜品所在餐馆id
     * @param rname
     * @return int
     */
    @Override
    public int selectIdbyrname(String rname) {
        return restaurantDao.selectIdbyrname(rname);
    }
    /**
     * 查询新增菜品id
     * @return int
     */
    @Override
    public int selectLastDish() {
        return restaurantDao.selectLastDish();
    }
    /**
     * 菜品餐馆表新增
     * @param dishrestaurant 菜品餐馆实体类
     */
    @Override
    public void insertDishRestaurant(Dishrestaurant dishrestaurant) {
        restaurantDao.insertDishRestaurant(dishrestaurant);
    }


}
