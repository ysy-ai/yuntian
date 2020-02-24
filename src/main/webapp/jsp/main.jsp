<%--
  Created by IntelliJ IDEA.
  User: 86132
  Date: 2019/12/9
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>云天-主界面</title>
</head>
<body>
<div style="border: 1px;height: 140px;line-height: 40px">
    <div style="height: 40px;background: #F8F8F8;">
        <div style="margin-left: 350px;float: left;">${city }</div>
        <div style="border: 1px solid silver;width: 65px;height:25px;line-height:25px;float: left;margin-left: 5px;margin-top: 7px"><a href="selectcityByprovince?city=${city}" style="text-decoration:none;color: black;">切换城市</a></div>
        <div style="margin-left: 20px;float: left;"><a href="judgementlogin?username=${username }" style="text-decoration:none;color: red">${username }</a></div>
        <div style="margin-left: 20px;float: left;"><a href="register.jsp" style="text-decoration:none;color: black">注册</a></div>
        <div style="margin-left: 15px;float: left;"><a href="../index.jsp" style="text-decoration:none;color: black;">退出</a></div>
        <div style="margin-left: 450px;float: left"><a href="judgementlogin?username=${username }" style="text-decoration:none;color: black;">我的云天</a></div>
        <div style="margin-left: 80px;float: left"><a href="jsp/login.jsp" style="text-decoration:none;color: black;">商家中心</a></div>
        <div style="margin-left: 80px;float: left"><a href="jsp/" style="text-decoration:none;color: black;">云天规则</a></div>
    </div>
    <div style="height: 100px;">
        <img style="position:absolute;left:350px;top:70px" alt="" src="">
        <form style="position:absolute;left:660px;top:75px;height: 30px;width: 500px" action="#">
            <input style="height: 30px;width: 400px;margin-bottom: 20px" type="text" name="" value="">
            <input type="submit" value="搜索">
        </form>
    </div>
    <div style="height: 30px;background: #F8F8F8;"></div>
</div>
</body>
</html>
