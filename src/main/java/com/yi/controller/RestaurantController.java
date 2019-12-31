package com.yi.controller;

import com.yi.dao.RestaurantDao;
import com.yi.service.RestaurantService;

/**
 * @author yisy
 */
public class RestaurantController {
    private final RestaurantService restaurantService;
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
}
