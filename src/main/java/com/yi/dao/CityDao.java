package com.yi.dao;

import com.yi.po.City;
import com.yi.po.Cuidsine;
import com.yi.po.Restaurant;
import com.yi.po.UtilFenye;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface CityDao {
    //按省份查询城市
    List<City> selectcityByhenan();
    List<City> selectcityByzhejiang();
    List<City> selectcityByshandong();
    List<City> selectcityBysichuan();
    List<City> selectcityByjiangsu();
    List<City> selectcityByguangdong();

    //查询菜系名称
    List<Cuidsine> selectCuidisne();

    //按当前城市名称查询所在省份的所有城市
    List<City> selectcityBycity(City city);

    //按菜系名称查询餐馆数量
    int selectrestauantcountBycuidisine(String cname);
    //按菜系名称查询餐馆
    List<Restaurant> selectrestauantBycuidisine(UtilFenye utilFenye);
    //按城市名称查询餐馆数量
    int selectrestauantcountBycity(String cityname);
    //按城市名称查询餐馆
    List<Restaurant> selectrestauantBycity(UtilFenye utilFenye);
}
