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
        request.getSession().setAttribute("city1",city1);
        //获取城市列表
        List<List> list = cityService.selectcityByprovince();
        List henan = list.get(0);
        List zhejiang = list.get(1);
        List shandong = list.get(2);
        List sichuan = list.get(3);
        List jiangsu = list.get(4);
        List guangdong = list.get(5);
        request.getSession().setAttribute("henan",henan);
        request.getSession().setAttribute("zhejiang",zhejiang);
        request.getSession().setAttribute("shandong",shandong);
        request.getSession().setAttribute("sichuan",sichuan);
        request.getSession().setAttribute("jiangsu",jiangsu);
        request.getSession().setAttribute("guangdong",guangdong);
        return "city";
    }

    /**
     * 获取城市名称
     */
    @RequestMapping("/getCityname")
    public String getCityname (String cityname1,HttpServletRequest request,UtilFenye utilFenye) {
        if (cityname1!=null) {
            System.out.println("444"+cityname1);
            String a = ",";
            String b = " ";
            String cityname2 = cityname1.replace(a, "").replace(b, "");
            if(cityname2==null||cityname2.equals("")||cityname2.equals(" ")){
                request.getSession().setAttribute("city",request.getSession().getAttribute("city"));
                request.setAttribute("falseMessage","请输入城市名称！！！");
                return "city";
            }
            request.getSession().setAttribute("city",cityname2);
            //按当前城市名称查询所在省份的所有城市
            City city = new City();
            city.setCityname(cityname2);
            List<City> cities = cityService.selectcityBycity(city);
            request.getSession().setAttribute("cities",cities);
        }
        //isEmpty():判断字符串是否为null
        String str = "cityname";
        if (!request.getParameter("cityname").isEmpty()&&request.getParameter(str)!=null&&!request.getParameter(str).equals("null")) {
            System.out.println("1111");
            //按当前城市名称查询所在省份的所有城市
            String cityname = new String(request.getParameter("cityname").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
            request.getSession().setAttribute("city",cityname);
            City city = new City();
            city.setCityname(cityname);
            List<City> cities = cityService.selectcityBycity(city);
            request.getSession().setAttribute("cities",cities);
        }
        return "main1";
    }

    /**
     * 根据菜系名称或城市名称查询餐馆
     */
    @RequestMapping("/getRestauantBycuidisine")
    public String getRestauantBycuidisine (UtilFenye utilFenye, HttpServletRequest request) {
        if(utilFenye.getName()!=null){
            String name = new String(utilFenye.getName().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
            request.getSession().setAttribute("name",name);
            utilFenye.setName(name);
        }
        if(utilFenye.getName()==null){
            String name = (String) request.getSession().getAttribute("name");
            utilFenye.setName(name);
        }
        utilFenye.setPageNow(Integer.parseInt(request.getParameter("pageNow")));
        if(utilFenye.getSign()!=null){
            String sign = new  String(utilFenye.getSign().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
            request.getSession().setAttribute("sign",sign);
        }
        if(utilFenye.getSign()==null){
            String sign = (String) request.getSession().getAttribute("sign");
            utilFenye.setSign(sign);
        }
        if("cu".equals(utilFenye.getSign())){
            Fenye fenye = cityService.selectrestauantBycuidisine(utilFenye);
            for (Restaurant restaurant:fenye.getList()) {
                restaurant.setCommentcount(restaurantService.selectCountComment(restaurant.getRname()));
            }
            request.getSession().setAttribute("fenye",fenye);
        }
        if ("ci".equals(utilFenye.getSign())){
            Fenye fenye = cityService.selectrestauantBycity(utilFenye);
            for (Restaurant restaurant:fenye.getList()) {
                restaurant.setCommentcount(restaurantService.selectCountComment(restaurant.getRname()));
            }
            request.getSession().setAttribute("fenye",fenye);
        }
        return "main1";
    }
}
