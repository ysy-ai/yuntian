package com.yi.controller;

import com.yi.po.*;
import com.yi.service.CityService;
import com.yi.service.RestaurantService;
import com.yi.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yisy
 */
@Controller
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final UsersService usersService;
    private final CityService cityService;

    public RestaurantController(RestaurantService restaurantService, UsersService usersService,CityService cityService) {
        this.restaurantService = restaurantService;
        this.usersService = usersService;
        this.cityService = cityService;
    }
    /**
     * 菜品展示
     */
    @RequestMapping("showDish")
    public String showDish(HttpServletRequest request) {
        String yi = request.getParameter("yi");
        try {
            String rname = new String(request.getParameter("rname").getBytes("ISO_8859_1"), StandardCharsets.UTF_8);
            List<Comment> comments = restaurantService.selectComment(rname);
            request.getSession().setAttribute("comments", comments);
            request.getSession().setAttribute("rname", rname);
            if("i".equals(yi)){
                List<Dish> dishes = restaurantService.selectDish(rname);
                for (Dish d:dishes) {
                    d.setRname(rname);
                }
                request.getSession().setAttribute("dishes", dishes);
                return "merchantDish";
            }
            List<Dish> dishes = restaurantService.selectDishe(rname);
            request.getSession().setAttribute("dishes", dishes);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "dish";
    }

    /**
     * 订单管理
     */
    @RequestMapping("/orderManagement")
    public String orderManagement(HttpServletRequest request, Order order) {
        order.setStatus(0);
        //用户账号
        String tel = (String) request.getSession().getAttribute("tel");
        if (tel != null && !"".equals(tel)) {
            order.setTel(tel);
            try {
                //项目(餐馆名+菜品名)
                String str = "jia1";
                String str1 = "jia";
                if (str.equals(request.getParameter(str1))) {
                    restaurantService.deleteOrderStatus();
                    String rname = new String(request.getParameter("rname").getBytes("ISO_8859_1"), StandardCharsets.UTF_8);
                    String dishName = new String(request.getParameter("dishName").getBytes("ISO_8859_1"), StandardCharsets.UTF_8);
                    String pictureUrl = new String(request.getParameter("pictureUrl").getBytes("ISO_8859_1"), StandardCharsets.UTF_8);
                    System.out.println(pictureUrl);
                    String name = rname + ":" + dishName;
                    order.setName(name);
                    order.setPictureUrl(pictureUrl);
                    System.out.println(order);
                    restaurantService.insertOrder(order);
                }
                if (str1.equals(request.getParameter(str1))) {
                    String name = new String(request.getParameter("name").getBytes("ISO_8859_1"), StandardCharsets.UTF_8);
                    String pictureUrl = new String(request.getParameter("pictureUrl").getBytes("ISO_8859_1"), StandardCharsets.UTF_8);
                    order.setPictureUrl(pictureUrl);
                    order.setName(name);
                    restaurantService.insertOrder(order);
                }
                String str2 = "jian";
                if (str2.equals(request.getParameter(str1))) {
                    String name = new String(request.getParameter("name").getBytes("ISO_8859_1"), StandardCharsets.UTF_8);
                    order.setName(name);
                    if (restaurantService.selectCountOrder(order) > 1) {
                        restaurantService.deleteOrder(restaurantService.selectOrderid(order));
                    }
                }
                Order order1 = restaurantService.selectOrder(order);
                //单价
                String price = new String(request.getParameter("price").getBytes("ISO_8859_1"), StandardCharsets.UTF_8);
                int prices1 = Integer.parseInt(price);
                //数量
                int countOrder = restaurantService.selectCountOrder(order);
                System.out.println(countOrder+"数量");
                //总价
                int total = prices1 * countOrder;
                request.getSession().setAttribute("order1", order1);
                request.getSession().setAttribute("prices1", prices1);
                request.getSession().setAttribute("countOrder", countOrder);
                request.getSession().setAttribute("total", total);

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            request.getSession().setAttribute("false", "请先登录!!!");
            return "dish";
        }
        return "order";
    }

    /**
     * 提交订单
     */
    @RequestMapping("/summitOrder")
    public String summitOrder(HttpServletRequest request,Order order) {
        try {
            String name = new String(request.getParameter("name").getBytes("ISO_8859_1"), StandardCharsets.UTF_8);
            String total = new String(request.getParameter("total").getBytes("ISO_8859_1"), StandardCharsets.UTF_8);
            //下单时间
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            order.setTime(sdf.format(date));
            order.setStatus(1);
            order.setName(name);
            order.setTel((String) request.getSession().getAttribute("tel"));
            System.out.println(order+"3");
            restaurantService.updateStatus(order);
            request.getSession().setAttribute("name", name);
            request.getSession().setAttribute("total", total);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "payOrder";
    }

    /**
     * 支付订单
     */
    @RequestMapping("/payOrder")
    public String payOrder(HttpServletRequest request, Order order) {
        order.setStatus(2);
        order.setName((String) request.getSession().getAttribute("name"));
        order.setTel((String) request.getSession().getAttribute("tel"));
        System.out.println(order+"4");
        restaurantService.updateStatus(order);
        String radio = request.getParameter("radio");
        String string = "微信";
        String string1 = "支付宝";
        if (string.equals(radio)) {
            return "wechat";
        }
        if (string1.equals(radio)) {
            return "zhifubao";
        }
        return "";
    }

    /**
     * 评论区
     */
    @RequestMapping("/comment")
    public String comment(MultipartFile file, HttpServletRequest request, Comment comment, Users users) {
        try {
            String rname = new String(request.getParameter("rname").getBytes("ISO_8859_1"), StandardCharsets.UTF_8);
            users.setPassword((String) request.getSession().getAttribute("name"));
            Users users1 = usersService.selectUsers(users);
            comment.setHeadurl(users1.getHeadPortrait());
            // 获得原始文件名
            String fileName = file.getOriginalFilename();
            // 上传位置
            // 设定文件保存的目录
            String path = "C:/Users/86132/IdeaProjects/yidemo1/src/main/webapp/images";
            if (!file.isEmpty()) {
                try {
                    FileOutputStream fos = new FileOutputStream(path + "/" + fileName);
                    InputStream in = file.getInputStream();
                    int b;
                    while ((b = in.read()) != -1) {
                        fos.write(b);
                    }
                    fos.close();
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //路径存入数据库
            comment.setPhotourl("images/" + fileName);
            comment.setText(comment.getText());
            comment.setRestaurantname(rname);
            restaurantService.insertComment(comment);
            List<Comment> comments = restaurantService.selectComment(rname);
            request.getSession().setAttribute("comments", rname);
            request.getSession().setAttribute("comments", comments);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "dish";
    }
    /**
     * 全部订单  待付款
     * status等于2（付款） status等于2（待付款）
     */
    @RequestMapping("/allOrder")
    public String allOrder(HttpServletRequest request,Order order1){
        try {
            String status1 = new String(request.getParameter("status1").getBytes("ISO_8859_1"), StandardCharsets.UTF_8);
            restaurantService.deleteOrderStatus();
            order1.setTel((String) request.getSession().getAttribute("tel"));
            String str = "1";
            if (status1.equals(str)) {
                request.getSession().setAttribute("status1","1");
                order1.setStatus(1);
            }
            List<Order> orders = restaurantService.selectAllOrder(order1);
            if(orders.isEmpty()){
                request.setAttribute("message","对不起，没有待付款的订单!");
            }
            List<AllOrder> list = new ArrayList<>();
            for (Order order:orders) {
                AllOrder allOrder = new AllOrder();
                //菜名
                String rname = order.getName().substring(0, order.getName().indexOf(":")).trim();
                String dishName = order.getName().substring(order.getName().indexOf(":") + 1).trim();
                //数量
                order.setTel((String) request.getSession().getAttribute("tel"));
                int count = restaurantService.selectCountOrder(order);
                //日期
                String time = order.getTime();
                //总价
                int price = restaurantService.selectDishPrice(dishName);
                int total = price*count;
                //付款状态
                int status = order.getStatus();
                if(status==1){
                    allOrder.setStatus("待付款");
                }
                if(status==2){
                    allOrder.setStatus("已付款");
                }
                allOrder.setPictureUrl(order.getPictureUrl());
                allOrder.setDishname(dishName);
                allOrder.setRname(rname);
                allOrder.setCount(count);
                allOrder.setTime(time);
                allOrder.setTotal(total);
                list.add(allOrder);
            }
            request.setAttribute("list",list);
            return "orderDisplay";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "orderDisplay";
    }
    /**
     * 根据时间和名字删除订单
     */
    @RequestMapping("/deleteOrder")
    public String deleteOrder(HttpServletRequest request , Order order1){
        try {
            String name = new String(order1.getName().getBytes("ISO_8859_1"), StandardCharsets.UTF_8);
            order1.setName("%"+name+"%");
            restaurantService.deleteOrderbyTime(order1);
            order1.setTel((String) request.getSession().getAttribute("tel"));
            String status1 = (String) request.getSession().getAttribute("status1");
            if (status1!=null) {
                order1.setStatus(1);
            }
            List<Order> orders = restaurantService.selectAllOrder(order1);
            if(orders.isEmpty()&&status1!=null){
                request.setAttribute("message","对不起，没有待付款的订单!");
            }
            if(orders.isEmpty()&&status1==null){
                request.setAttribute("message","对不起，目前您暂无订单!");
            }
            List<AllOrder> list = new ArrayList<>();
            for (Order order:orders) {
                AllOrder allOrder = new AllOrder();
                //菜名
                String rname = order.getName().substring(0, order.getName().indexOf(":")).trim();
                String dishName = order.getName().substring(order.getName().indexOf(":") + 1).trim();
                //数量
                order.setTel((String) request.getSession().getAttribute("tel"));
                int count = restaurantService.selectCountOrder(order);
                //日期
                String time = order.getTime();
                //总价
                int price = restaurantService.selectDishPrice(dishName);
                int total = price*count;
                //付款状态
                int status = order.getStatus();
                if(status==1){
                    allOrder.setStatus("待付款");
                }
                if(status==2){
                    allOrder.setStatus("已付款");
                }
                allOrder.setPictureUrl(order.getPictureUrl());
                allOrder.setDishname(dishName);
                allOrder.setRname(rname);
                allOrder.setCount(count);
                allOrder.setTime(time);
                allOrder.setTotal(total);
                list.add(allOrder);
            }
            request.setAttribute("list",list);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "orderDisplay";
    }
    /**
     * 待使用、待评价、退款售后
     */
    @RequestMapping("/noused")
    public String noused(HttpServletRequest request){
        request.setAttribute("message","对不起，没有可以使用的订单!");
        return "orderDisplay";
    }
    @RequestMapping("/nocomment")
    public String nocomment(HttpServletRequest request){
        request.setAttribute("message","对不起，没有可以评价的订单!");
        return "orderDisplay";
    }
    @RequestMapping("/refund")
    public String refund(HttpServletRequest request){
        request.setAttribute("message","对不起，没有可以使用的订单!");
        return "orderDisplay";
    }
    /**
     * 猜你喜欢
     */
    @RequestMapping("/selectrestauantBycity")
    public String selectrestauantBycity(HttpServletRequest request , UtilFenye utilFenye){
        utilFenye.setName(request.getParameter("name"));
        utilFenye.setPageNow(Integer.parseInt(request.getParameter("pageNow")));
        Fenye fenye = cityService.selectrestauantBycity(utilFenye);
        for (Restaurant restaurant:fenye.getList()) {
            restaurant.setCommentcount(restaurantService.selectCountComment(restaurant.getRname()));
        }
        request.getSession().setAttribute("fenye",fenye);
        return "yuantian";
    }

    /**
     * 商家中心
     */
    /**
     * 商家注册
     */
    @RequestMapping("/registerRestaurantcenter")
    public String registerRestaurantcenter(){
        return "registerRestaurant";
    }
    @RequestMapping("/registerRestaurant")
    public String registerRestaurant(MultipartFile file, Restaurant restaurant, HttpServletRequest request) {
        // 获得原始文件名
        String fileName = file.getOriginalFilename();
        // 上传位置
        // 设定文件保存的目录
        String path = "C:/Users/86132/IdeaProjects/yidemo1/src/main/webapp/images";
        if (!file.isEmpty()) {
            try {
                FileOutputStream fos = new FileOutputStream(path + "/" + fileName);
                InputStream in = file.getInputStream();
                int b;
                while ((b = in.read()) != -1) {
                    fos.write(b);
                }
                fos.close();
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //路径存入数据库
        System.out.println(fileName);
        restaurant.setUrl("images/" + fileName);
        restaurantService.insertRestauart(restaurant);
        int cityid = restaurantService.selectIdbycityname((String) request.getSession().getAttribute("city"));
        int restaurantid = restaurantService.selectLastRestaurant();
        Cityrestaurant cityrestaurant = new Cityrestaurant();
        cityrestaurant.setCityid(cityid);
        cityrestaurant.setRestaurantid(restaurantid);
        restaurantService.insertCityrestaurant(cityrestaurant);
        request.getSession().setAttribute("success", "注册成功");
        if(restaurantService.selectCuidsine(restaurant.getType())==null){
            restaurantService.insertCuidsine(restaurant.getType());
        }
        return "registerRestaurant";
    }
    /**
     * 商家详情
     */
    @RequestMapping("/merchantDetails")
    public String merchantDetails(HttpServletRequest request){
        List<Restaurant> list = restaurantService.selectRestaurantbytel((String) request.getSession().getAttribute("tel"));
        if(list.isEmpty()){
            request.getSession().setAttribute("isEmpty","您暂无爱店，快去注册吧！");
            return "merchantDetails";
        }
        request.getSession().setAttribute("list",list);
        return "merchantDetails";
    }
    /**
     * 注销餐馆
     */
    @RequestMapping("/deleteRestaurant")
    public String deleteRestaurant(Restaurant restaurant,HttpServletRequest request){
        restaurantService.deletecityRestaurantbyrid(restaurant.getId());
        restaurantService.deletedishRestaurantbyrid(restaurant.getId());
        restaurantService.deleteRestaurant(restaurant.getId());
        List<Restaurant> list = restaurantService.selectRestaurantbytel(restaurant.getTel());
        request.getSession().setAttribute("list",list);
        return "merchantDetails";
    }
    /**
     * 上架、下架
     */
    @RequestMapping("/updateDishStatus")
    public String updateDishStatus(Dish dish , HttpServletRequest request){
        int id =Integer.parseInt(request.getParameter("id"));
        int status =Integer.parseInt(request.getParameter("status"));
        if(status==0){
            dish.setStatus(1);
            dish.setStatusDetails("上架");
        }
        if(status==1){
            dish.setStatus(0);
            dish.setStatusDetails("下架");
        }
        dish.setId(id);
        restaurantService.updateDishStatus(dish);
        try {
            String rname = new String(request.getParameter("rname").getBytes("ISO_8859_1"), StandardCharsets.UTF_8);
            request.getSession().setAttribute("rname",rname);
            List<Dish> dishes = restaurantService.selectDish(rname);
            for (Dish d:dishes) {
                d.setRname(rname);
            }
            request.getSession().setAttribute("dishes", dishes);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "merchantDish";
    }
    /**
     * 删除评论
     */
    @RequestMapping("/deleteComment")
    public String deleteComment(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        restaurantService.deleteCommentbyId(id);
        String rname = (String) request.getSession().getAttribute("rname");
        List<Comment> comments = restaurantService.selectComment(rname);
        request.getSession().setAttribute("comments", comments);
        return "merchantDish";
    }
    /**
     * 新菜上架
     */
    @RequestMapping("/upperShelf")
    public String upperShelf(MultipartFile file, HttpServletRequest request,Dish dish){
        // 获得原始文件名
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        // 上传位置
        // 设定文件保存的目录
        String path = "C:/Users/86132/IdeaProjects/yidemo1/src/main/webapp/images";
        if (!file.isEmpty()) {
            try {
                FileOutputStream fos = new FileOutputStream(path+"/"+fileName);
                InputStream in = file.getInputStream();
                int b;
                while ((b = in.read()) != -1) {
                    fos.write(b);
                }
                fos.close();
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //路径存入数据库
        dish.setPictureUrl("images/"+fileName);
        dish.setStatus(0);
        dish.setStatusDetails("下架");
        restaurantService.insertDish(dish);
        int rid = restaurantService.selectIdbyrname((String) request.getSession().getAttribute("rname"));
        int did = restaurantService.selectLastDish();
        Dishrestaurant dishrestaurant = new Dishrestaurant();
        dishrestaurant.setDishid(did);
        dishrestaurant.setRestaurantid(rid);
        restaurantService.insertDishRestaurant(dishrestaurant);
        request.getSession().setAttribute("success", "新增成功");
        return "registerDish";
    }
    /**
     * 全局搜索餐馆
     */
    @RequestMapping("/selectRestaurantByRnameAndDishname")
    public String selectRestaurantByRnameAndDishname(UtilFenye utilFenye,HttpServletRequest request){
        try {
            String cityname = new String(utilFenye.getCityname().getBytes("ISO-8859-1"),"utf-8");
            utilFenye.setCityname(cityname);
            utilFenye.setRname("%"+utilFenye.getRname()+"%");
            Fenye fenye = restaurantService.selectRestaurantByRnameAndDishname(utilFenye);
            if(fenye.getList().isEmpty()){
                fenye.setPageNow(1);
                request.getSession().setAttribute("fenye",fenye);
                request.getSession().setAttribute("noMessage","对不起，没有符合条件的商家");
                return "main1";
            }
            for (Restaurant restaurant:fenye.getList()) {
                restaurant.setCommentcount(restaurantService.selectCountComment(restaurant.getRname()));
            }
            request.getSession().setAttribute("fenye",fenye);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "main1";
    }
    /**
     * businesscenter
     */
    @RequestMapping("/businesscenter")
    public String businesscenter(){
        return "businessCenter";
    }
    /**
     * businesscenter
     */
    @RequestMapping("/insertDish")
    public String insertDish(){
        return "personMessage";
    }



}
