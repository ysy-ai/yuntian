package com.yi.service.impl;

import com.yi.dao.CityDao;
import com.yi.dao.RestaurantDao;
import com.yi.service.RestaurantService;
import org.springframework.stereotype.Service;

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
}
