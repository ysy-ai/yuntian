package com.yi.service;

import com.yi.po.*;

import java.util.List;

public interface CityService {
    //按省份查询城市
    List<List> selectcityByprovince();

    //查询菜系名称
    List<Cuidsine> selectCuidisne();

    //按当前城市名称查询所在省份的所有城市
    List<City> selectcityBycity(City city);

    //按菜系名称查询餐馆
    Fenye selectrestauantBycuidisine(UtilFenye utilFenye);
    //按城市名称查询餐馆
    Fenye selectrestauantBycity(UtilFenye utilFenye);
}
