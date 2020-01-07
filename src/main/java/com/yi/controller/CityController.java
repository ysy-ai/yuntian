package com.yi.controller;

import com.yi.po.*;
import com.yi.service.CityService;
import com.yi.service.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author yisy
 */
@Controller
public class CityController {
    /**
     * 自动注入
     */
    private final CityService cityService;
    private final RestaurantService restaurantService;
    public CityController(CityService cityService,RestaurantService restaurantService) {
        this.cityService = cityService;
        this.restaurantService=restaurantService;
    }

    /**
     * 主页默认展示
     */
    @RequestMapping("/toMain")
    public String toMain (UtilFenye utilFenye,HttpServletRequest request) {
        request.getSession().setAttribute("city","息县");
        request.getSession().setAttribute("username","立即登录");
        //查询菜系
        List<Cuidsine> cuidsines = cityService.selectCuidisne();
        //按当前城市名称查询所在省份的所有城市
        City city = new City();
        city.setCityname("息县");
        List<City> cities = cityService.selectcityBycity(city);
        //按城市名称查询餐馆
        utilFenye.setName("息县");
        utilFenye.setPageNow(Integer.parseInt(request.getParameter("pageNow")));
        Fenye fenye = cityService.selectrestauantBycity(utilFenye);
        for (Restaurant restaurant:fenye.getList()) {
            restaurant.setCommentcount(restaurantService.selectCountComment(restaurant.getRname()));
        }
        request.getSession().setAttribute("cuidsines",cuidsines);
        request.getSession().setAttribute("cities",cities);
        request.getSession().setAttribute("fenye",fenye);
        return "main1";
    }

    /**
     * 按省份查询城市
     */
    @RequestMapping("/selectcityByprovince")
    public String selectcityByprovince (HttpServletRequest request) {
        //经常访问的城市
        String city = request.getParameter("city");
        String city1 = new String(city.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        request.setAttribute("city1",city1);
        //获取城市列表
        List<List> list = cityService.selectcityByprovince();
        List henan = list.get(0);
        List zhejiang = list.get(1);
        List shandong = list.get(2);
        List sichuan = list.get(3);
        List jiangsu = list.get(4);
        List guangdong = list.get(5);
        request.setAttribute("henan",henan);
        request.setAttribute("zhejiang",zhejiang);
        request.setAttribute("shandong",shandong);
        request.setAttribute("sichuan",sichuan);
        request.setAttribute("jiangsu",jiangsu);
        request.setAttribute("guangdong",guangdong);
        return "city";
    }

    /**
     * 获取城市名称
     */
    @RequestMapping("/getCityname")
    public String getCityname (String cityname1,HttpServletRequest request) {
        if (cityname1!=null) {
            String a = ",";
            String b = " ";
            String cityname2 = cityname1.replace(a, "").replace(b, "");
            request.getSession().setAttribute("city",cityname2);
            //按当前城市名称查询所在省份的所有城市
            City city = new City();
            city.setCityname(cityname2);
            List<City> cities = cityService.selectcityBycity(city);
            request.getSession().setAttribute("cities",cities);
        }
        //isEmpty():判断字符串是否为null
        String str = "cityname";
        if (!request.getParameter(str).isEmpty()&&request.getParameter(str)!=null&&!request.getParameter(str).equals("null")) {
            //按当前城市名称查询所在省份的所有城市
            String cityname = new String(request.getParameter("cityname").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
            City city = new City();
            city.setCityname(cityname);
            List<City> cities = cityService.selectcityBycity(city);
            request.getSession().setAttribute("cities",cities);
            request.getSession().setAttribute("city",cityname);
        }
        return "main1";
    }

    /**
     * 根据菜系名称或城市名称查询餐馆
     */
    @RequestMapping("/getRestauantBycuidisine")
    public String getRestauantBycuidisine (UtilFenye utilFenye, HttpServletRequest request) {
        String name = new String(utilFenye.getName().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        utilFenye.setName(name);
        utilFenye.setPageNow(Integer.parseInt(request.getParameter("pageNow")));
        Fenye fenye = cityService.selectrestauantBycuidisine(utilFenye);
        for (Restaurant restaurant:fenye.getList()) {
            restaurant.setCommentcount(restaurantService.selectCountComment(restaurant.getRname()));
        }
        request.getSession().setAttribute("fenye",fenye);
        return "main1";
    }

    /**
     * 根据城市名称查询餐馆
     */
    @RequestMapping("/getRestauantBycity")
    public String getRestauantBycity (UtilFenye utilFenye,HttpServletRequest request) {
        utilFenye.setName(request.getParameter("name"));
        utilFenye.setPageNow(Integer.parseInt(request.getParameter("pageNow")));
        Fenye fenye = cityService.selectrestauantBycity(utilFenye);
        for (Restaurant restaurant:fenye.getList()) {
            restaurant.setCommentcount(restaurantService.selectCountComment(restaurant.getRname()));
        }
        request.getSession().setAttribute("fenye",fenye);
        return "main1";
    }
}
