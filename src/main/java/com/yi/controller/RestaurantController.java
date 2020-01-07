package com.yi.controller;

import com.yi.po.*;
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

    public RestaurantController(RestaurantService restaurantService, UsersService usersService) {
        this.restaurantService = restaurantService;
        this.usersService = usersService;
    }

    /**
     * 餐馆注册
     */
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
        restaurant.setUrl("images/" + fileName);
        restaurant.setRname(restaurant.getRname());
        restaurant.setAddress(restaurant.getAddress());
        restaurant.setTel(restaurant.getTel());
        restaurant.setPerprice(restaurant.getPerprice());
        restaurantService.insertRestauart(restaurant);
        request.getSession().setAttribute("success", "注册成功");
        return "registerRestaurant";
    }

    /**
     * 菜品展示
     */
    @RequestMapping("showDish")
    public String showDish(HttpServletRequest request) {
        try {
            String rname = new String(request.getParameter("rname").getBytes("ISO_8859_1"), StandardCharsets.UTF_8);
            List<Dish> dishes = restaurantService.selectDish(rname);
            List<Comment> comments = restaurantService.selectComment(rname);
            request.getSession().setAttribute("comments", comments);
            request.getSession().setAttribute("rname", rname);
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
            request.getSession().setAttribute("false", "请先登录");
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
            request.getSession().setAttribute("comments", comments);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "dish";
    }
    /**
     * 全部订单
     */
    @RequestMapping("allOrder")
    public String allOrder(HttpServletRequest request,AllOrder allOrder,Order order1){
        restaurantService.deleteOrderStatus();
        List<AllOrder> list = new ArrayList<>();
        order1.setTel((String) request.getSession().getAttribute("tel"));
        List<Order> orders = restaurantService.selectAllOrder(order1);
        System.out.println(orders);
        for (Order order:orders) {
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
            System.out.println(total+"total");
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
        request.getSession().setAttribute("list",list);
        return "yuantian";
    }
}
