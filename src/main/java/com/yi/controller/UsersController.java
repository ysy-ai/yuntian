package com.yi.controller;

import com.yi.po.Users;
import com.yi.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;


@Controller
//@RequestMapping("/users")
public class UsersController {
    //自动注入
    private final UsersService usersService;
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    //判断是否登录
    @RequestMapping("/Judgementlogin")
    public String Judgementlogin (HttpServletRequest request) {
        String username = new String(request.getParameter("username").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        if (username.equals("立即登录")) {
            return "login";
        }
        System.out.println(username);
        request.getSession().setAttribute("username",username);
        return "yuantian";
    }

    //用户登录
    //验证用户名是否存在
    @RequestMapping(value = "/validateUser",method = RequestMethod.POST,produces = {"text/html;charset=utf-8"})
    public @ResponseBody String validateUser (Users users) {
        boolean flag = usersService.selectTel(users);
        if (flag) {
            return "账号不存,请前往注册";
        }
        return " ";
    }
    //验证密码
    @RequestMapping(value = "/validatePassword",method = RequestMethod.POST)
    public String validatePassword (Users users,HttpServletRequest request) {
        boolean flag = usersService.selectPassword(users);
        if (flag) {
            //创建初始昵称
            Users users1 = usersService.selectUsers(users);
            users.setId(users1.getId());
            users.setHeadPortrait(users1.getHeadPortrait());
            users.setBirthday(users1.getBirthday());
            users.setStatus(users1.getStatus());
            String username = users.getTel();
            users.setUsername(username);
            usersService.updateUsers(users);
            request.getSession().setAttribute("username",users.getUsername());
            return "main1";
        }
        request.setAttribute("error","密码错误，请重新输入");
        return "login";
    }

    //用户注册
    @RequestMapping("/Register")
    public String Register (Users users,HttpServletRequest request) {
        if (usersService.selectTel(users)) {
            usersService.insertUsers(users);
            return "login";
        }
        request.getSession().setAttribute("error","用户存在,请直接登录");
        return "login";
    }

    //个人信息设置
    @RequestMapping("/getPersonMessage")
    public String getPersonMessage (Users users,HttpServletRequest request) {
        String username = new String(request.getParameter("username").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        users.setUsername(username);
        Users users1 = usersService.selectUsers(users);
        request.getSession().setAttribute("users",users);
        return "personMessage";
    }

    //上传头像
    @RequestMapping("/upload")
    public String upload (@PathVariable MultipartFile file, Users users, HttpServletRequest request, Model model) throws IOException {
        System.out.println(file);
        System.out.println(users);
        String username = (String) request.getSession().getAttribute("username");
        System.out.println(username);
        // 保存数据库的路径
        String realPath = request.getSession().getServletContext().getRealPath("/");
        //String sqlPath = null;
        // 定义文件保存的本地路径
        //String localPath = "D:\\File\\";
        // 定义 文件名
        boolean empty = users.getFile().isEmpty();
        System.out.println(empty);
        String filename = null;
        if (!users.getFile().isEmpty()) {
            // 生成uuid作为文件名称
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            // 获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType = users.getFile().getContentType();
            // 获得文件后缀名
            String suffixName = contentType
                    .substring(contentType.indexOf("/") + 1);
            // 得到 文件名
            filename = uuid + "." + suffixName;
            // 文件保存路径
            users.getFile().transferTo(new File(realPath + "/images/"+ filename));
        }
        // 把图片的相对路径保存至数据库
        //sqlPath = "/images/" + filename;
        //System.out.println(sqlPath);
        System.out.println(filename);
        Users users1 = usersService.selectUsers(users);
        users1.setHeadPortrait(filename);
        model.addAttribute("user", users1);
        return "personMessage";
    }



}
