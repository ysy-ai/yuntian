package com.yi.service;

import com.yi.po.*;

import java.util.List;

/**
 * @author yisy
 */
public interface CityService {
    /**
     * 按省份查询城市
     * @return List 城市列表
     */
    List<List> selectcityByprovince();
    /**
     * 查询菜系名称
     * @return Cuidsine 菜系实体类
     */
    List<Cuidsine> selectCuidisne();
    /**
     * 按当前城市名称查询所在省份的所有城市
     * @param city 城市实体类
     * @return City 城市实体类
     */
    List<City> selectcityBycity(City city);
    /**
     * 按菜系名称查询餐馆
     * @param utilFenye 分页实体类
     * @return Fenye
     */
    Fenye selectrestauantBycuidisine(UtilFenye utilFenye);
    /**
     * 按城市名称查询餐馆
     */
    Fenye selectrestauantBycity(UtilFenye utilFenye);
}
