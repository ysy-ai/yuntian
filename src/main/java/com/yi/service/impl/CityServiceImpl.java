package com.yi.service.impl;

import com.yi.dao.CityDao;
import com.yi.po.*;
import com.yi.service.CityService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    //自动注入
    private final CityDao cityDao;
    public CityServiceImpl(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    //按省份查询城市
    @Override
    public List<List> selectcityByprovince() {
        List list = new ArrayList();
        List<City> henan = cityDao.selectcityByhenan();
        List<City> zhejiang = cityDao.selectcityByzhejiang();
        List<City> shandong = cityDao.selectcityByshandong();
        List<City> sichuan = cityDao.selectcityBysichuan();
        List<City> jiangsu = cityDao.selectcityByjiangsu();
        List<City> guangdong = cityDao.selectcityByguangdong();
        list.add(henan);
        list.add(zhejiang);
        list.add(shandong);
        list.add(sichuan);
        list.add(jiangsu);
        list.add(guangdong);
        return list;
    }

    //查询菜系名称
    @Override
    public List<Cuidsine> selectCuidisne() {
        List<Cuidsine> cuidsines = cityDao.selectCuidisne();
        return cuidsines;
    }

    //按当前城市名称查询所在省份的所有城市
    @Override
    public List<City> selectcityBycity(City city) {
        System.out.println(cityDao.selectcityBycity(city).size());
        List<City> cities = cityDao.selectcityBycity(city);
        return cities;
    }

    //按菜系名称查询餐馆
    @Override
    public Fenye selectrestauantBycuidisine(UtilFenye utilFenye) {
        System.out.println(utilFenye.getName());
        Fenye fenye=new Fenye();
        fenye.setPageCount(2);
        //一页数量
        int PageCount=fenye.getPageCount();
        //总条数
        int totalCount=cityDao.selectrestauantcountBycuidisine(utilFenye.getName());
        fenye.setTotalCount(totalCount);
        fenye.setPageNow(utilFenye.getPageNow());
        int d1=(fenye.getPageNow()-1)*fenye.getPageCount();
        int d2=2;
        utilFenye.setD1(d1);
        utilFenye.setD2(d2);
        utilFenye.setName(utilFenye.getName());
        List<Restaurant> list=cityDao.selectrestauantBycuidisine(utilFenye);
        fenye.setList(list);
        return fenye;
    }

    //按城市名称查询餐馆
    @Override
    public Fenye selectrestauantBycity(UtilFenye utilFenye) {
        Fenye fenye=new Fenye();
        fenye.setPageCount(2);
        //一页数量
        int PageCount=fenye.getPageCount();
        //总条数
        int totalCount=cityDao.selectrestauantcountBycity(utilFenye.getName());
        fenye.setTotalCount(totalCount);
        fenye.setPageNow(utilFenye.getPageNow());
        int d1=(fenye.getPageNow()-1)*fenye.getPageCount();
        int d2=2;
        utilFenye.setD1(d1);
        utilFenye.setD2(d2);
        utilFenye.setName(utilFenye.getName());
        List<Restaurant> list=cityDao.selectrestauantBycity(utilFenye);
        fenye.setList(list);
        return fenye;
    }
}
