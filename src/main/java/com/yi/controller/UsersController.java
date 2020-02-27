package com.yi.controller;

import com.yi.po.Users;
import com.yi.service.RestaurantService;
import com.yi.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yisy
 */
@Controller
public class UsersController {
    /**
     * 自动注入
     */
    private final UsersService usersService;
    private final RestaurantService restaurantService;
    public UsersController(UsersService usersService,RestaurantService restaurantService) {
        this.usersService = usersService;
        this.restaurantService = restaurantService;
    }
    /**
     * 判断是否登录
     */
    @RequestMapping("/judgementlogin")
    public String judgementlogin(Users users, HttpServletRequest request) {
        String username = new String(request.getParameter("username").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String str = "立即登录";
        if (str.equals(username)) {
            return "login";
        }
        users.setTel((String) request.getSession().getAttribute("tel"));
        Users users1 = usersService.selectUsername(users);
        request.getSession().setAttribute("users1",users1);
        request.getSession().setAttribute("username", username);
        return "yuantian";
    }

    /**
     * 用户登录(已弃用)
     * 验证用户名是否存在
     */
    @RequestMapping(value = "/validateUser", method = RequestMethod.POST, produces = {"text/html;charset=utf-8"})
    public @ResponseBody
    String validateUser(Users users) {
        boolean flag = usersService.selectTel(users);
        if (flag) {
            return "账号不存,请前往注册";
        }
        return " ";
    }

    /**
     * 用户登录
     */
    @RequestMapping(value = "/validatePassword", method = RequestMethod.POST)
    public String validatePassword(Users users, HttpServletRequest request) {
        boolean flag = usersService.selectTel(users);
        if (flag) {
            request.setAttribute("error", "账号不存,请前往注册");
            return "login";
        }
        boolean flag1 = usersService.selectPassword(users);
        if (flag1) {
            Users users1 = usersService.selectUsers(users);
            if(users1.getStatus().equals("0")){
                //创建初始昵称
                users.setId(users1.getId());
                users.setBirthday(users1.getBirthday());
                users.setStatus(users1.getStatus());
                if (users1.getUsername()==null) {
                    users.setUsername(users.getTel());
                }
                if(users1.getUsername()!=null&&!users1.getUsername().isEmpty()&&!"".equals(users1.getUsername())){
                    users.setUsername(users1.getUsername());
                }
                usersService.updateUsers(users);
                request.getSession().setAttribute("tel", users.getTel());
                request.getSession().setAttribute("username", users.getUsername());
                if("0".equals(users1.getStatus())){
                    return "main1";
                }
            }
            request.getSession().setAttribute("tel", users.getTel());
            return "businessCenter";
        }
        request.setAttribute("error", "密码错误，请重新输入");
        return "login";
    }

    /**
     * 用户注册
     */
    @RequestMapping("/register")
    public String register(Users users, HttpServletRequest request) {
        System.out.println(users);
        String pattern = "^1\\d{10}$";
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        System.out.println(r+"pattern");
        // 现在创建 matcher 对象
        Matcher m = r.matcher(users.getTel());
        if(m.find()){
            if (usersService.selectTel(users)) {
                if(users.getPassword().equals(users.getPasswords())){
                    if(users.getStatus()!=null){
                        usersService.insertUsers(users);
                        return "login";
                    }
                    request.setAttribute("error", "请选择普通用户或商家！");
                    return "register";
                }
                request.setAttribute("error", "密码错误，请重新输入!");
                return "register";
            }
        }
        if(!m.find()){
            request.setAttribute("error", "请输入正确的账号格式!");
            return "register";
        }
        request.setAttribute("error", "用户存在,请直接登录");
        return "login";
    }

    /**
     * 个人信息设置
     */
    @RequestMapping("/getPersonMessage")
    public String getPersonMessage(Users users, HttpServletRequest request) {
        users.setTel((String) request.getSession().getAttribute("tel"));
        Users userss = usersService.selectTels(users);
        request.getSession().setAttribute("userss", userss);
        return "personMessage";
    }
    /**
     * 上传头像
     */
    @RequestMapping("/upload")
    public String upload(MultipartFile file, HttpServletRequest request,Users users1) {
        // 新文件名
        String newFileName = request.getSession().getAttribute("tel") + ".jpg";
        // 获得项目的路径
        ServletContext sc = request.getSession().getServletContext();
        // 上传位置
        // 设定文件保存的目录
        String path = "C:/Users/86132/IdeaProjects/yidemo1/src/main/webapp/images";
        if (!file.isEmpty()) {
            try {
                FileOutputStream fos = new FileOutputStream(path+"/"+newFileName);
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
        users1.setTel((String) request.getSession().getAttribute("tel"));
        users1.setUsername((String) request.getSession().getAttribute("username"));
        Users users = usersService.selectUsername(users1);
        System.out.println(users);
        users.setHeadPortrait("images/"+newFileName);
        users.setTel((String) request.getSession().getAttribute("tel"));
        usersService.updateUsers(users);
        request.getSession().setAttribute("users",users);
        return "yuantian";
}

    /**
     * 修改个人信息
     */
    @RequestMapping("/updatePersonMessage")
    public String updatePersonMessage(Users users, HttpServletRequest request) {
        users.setTel((String) request.getSession().getAttribute("tel"));
        if (users.getUsername()!=null&&!users.getUsername().isEmpty()&&!"".equals(users.getUsername())) {
            Users usersss = usersService.selectTels(users);
            usersss.setUsername(users.getUsername());
            usersService.updateUsers(usersss);
            Users userss = usersService.selectTels(users);
            request.getSession().setAttribute("userss",userss);
        }
        if (users.getBirthday()!=null&&!users.getBirthday().isEmpty()&&!"".equals(users.getBirthday())) {
            Users usersss = usersService.selectTels(users);
            usersss.setBirthday(users.getBirthday());
            usersService.updateUsers(usersss);
            Users userss = usersService.selectTels(users);
            request.getSession().setAttribute("userss",userss);
        }
        if (users.getPassword()!=null&&!users.getPassword().isEmpty()&&!"".equals(users.getPassword())) {
            Users usersss = usersService.selectTels(users);
            usersss.setPassword(users.getPassword());
            usersService.updateUsers(usersss);
            Users userss = usersService.selectTels(users);
            request.getSession().setAttribute("userss",userss);
        }
        return "personMessage";
    }
    /**
     * 用户注销
     */
    @RequestMapping("/deleteUser")
    public String deleteUser(HttpServletRequest request){
        if(request.getSession().getAttribute("tel")==null){
            request.getSession().setAttribute("error","请先登录!");
            return "login";
        }
        usersService.deleteUser((String) request.getSession().getAttribute("tel"));
        restaurantService.deleteRestaurantbyTel((String) request.getSession().getAttribute("tel"));
        return "deleteUser";
    }
    /**
     * 退出
     */
    @RequestMapping("/exit")
    public String exit(){
        return "../index";
    }
    /**
     * 注册center
     */
    @RequestMapping("/zhu")
    public String zhu(){
        return "register";
    }
    /**
     * 登录center
     */
    @RequestMapping("/deng")
    public String deng(){
        return "login";
    }
    /**
     * personcenter
     */
    @RequestMapping("/personcenter")
    public String personcenter(){
        return "personMessage";
    }
}
