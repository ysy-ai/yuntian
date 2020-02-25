package com.yi.controller;

import com.yi.po.Users;
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

/**
 * @author yisy
 */
@Controller
public class UsersController {
    /**
     * 自动注入
     */
    private final UsersService usersService;
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
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
        Users users1 = usersService.selectUsers(users);
        request.getSession().setAttribute("users1",users1);
        request.getSession().setAttribute("username", username);
        return "yuantian";
    }

    /**
     * 用户登录
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
     * 验证密码
     */
    @RequestMapping(value = "/validatePassword", method = RequestMethod.POST)
    public String validatePassword(Users users, HttpServletRequest request) {
        boolean flag = usersService.selectPassword(users);
        Users users1 = usersService.selectUsers(users);
        if (flag) {
            //创建初始昵称
            users.setId(users1.getId());
            users.setHeadPortrait(users1.getHeadPortrait());
            users.setBirthday(users1.getBirthday());
            users.setStatus(users1.getStatus());
            if (users1.getUsername()==null) {
                users.setUsername(users.getTel());
            }else{
                users.setUsername(users1.getUsername());
            }
            usersService.updateUsers(users);
            request.getSession().setAttribute("tel", users.getTel());
            request.getSession().setAttribute("username", users.getUsername());
            if("0".equals(users1.getStatus())){
                return "main1";
            }
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
        if (usersService.selectTel(users)) {
            usersService.insertUsers(users);
            return "login";
        }
        request.getSession().setAttribute("error", "用户存在,请直接登录");
        return "login";
    }

    /**
     * 个人信息设置
     */
    @RequestMapping("/getPersonMessage")
    public String getPersonMessage(Users users, HttpServletRequest request) {
        users.setTel((String) request.getSession().getAttribute("tel"));
        Users userss = usersService.selectUsers(users);
        request.getSession().setAttribute("userss", userss);
        return "personMessage";
    }
    /**
     * 上传头像
     */
    @RequestMapping("/upload")
    public String upload(MultipartFile file, HttpServletRequest request) {
        Users users2 = new Users();
        users2.setTel((String) request.getSession().getAttribute("tel"));
        // 获得原始文件名
        String fileName = file.getOriginalFilename();
        // 新文件名
        String newFileName = "head" + ".jpg";
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
        Users users = usersService.selectUsers(users2);
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
        Users users2 = new Users();
        users2.setTel((String) request.getSession().getAttribute("tel"));
        if (users.getUsername()!=null) {
            Users userss = usersService.selectUsers(users2);
            userss.setUsername(users.getUsername());
            usersService.updateUsers(userss);
            request.getSession().setAttribute("userss",userss);
        }
        if (users.getBirthday()!=null) {
            Users userss = usersService.selectUsers(users2);
            userss.setBirthday(users.getBirthday());
            usersService.updateUsers(userss);
            request.getSession().setAttribute("userss",userss);
        }
        if (users.getTel()!=null) {
            Users userss = usersService.selectUsers(users2);
            userss.setTel(users.getTel());
            usersService.updateUsers(userss);
            request.getSession().setAttribute("userss",userss);
        }
        if (users.getPassword()!=null) {
            Users userss = usersService.selectUsers(users2);
            userss.setPassword(users.getPassword());
            usersService.updateUsers(userss);
            request.getSession().setAttribute("users",userss);
        }
        return "personMessage";
    }
    /**
     * 用户注销
     */
    @RequestMapping("/deleteUser")
    public String deleteUser(HttpServletRequest request){
        if((String) request.getSession().getAttribute("tel")==null){
            return "login";
        }
        usersService.deleteUser((String) request.getSession().getAttribute("tel"));
        return "deleteUser";
    }
}
