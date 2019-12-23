<%--
  Created by IntelliJ IDEA.
  User: 86132
  Date: 2019/12/13
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>云天-云天</title>
    <style type="text/css">

        #d1,#d2,#d3,#d4,#d5,#d6,#d7,#d8,#d9,#d10,#d11,#d12{
            text-decoration: none;
        }

        ul li #d1.h:HOVER {color: red;}

    </style>
</head>
<body>
<jsp:include page="main.jsp"></jsp:include><br><br>
<div style="height: 600px;width: 300px;border: 1px solid silver;float: left;margin-left: 350px">
    <ul style="list-style: none;line-height: 30px;height: 30px">
        <li style="font-size: 20px"><a id="d1" href="#" style="color: black;">我的美团</a></li>
        <li style="font-size: 20px"><a id="d2" href="#" style="color: black;">我的订单</a></li>
        <li style="font-size: 17px"><a id="d3" href="#" style="color: silver;">全部订单　　　　　　></a></li>
        <li style="font-size: 17px"><a id="d4" href="#" style="color: silver;">待付款　　　　　　　></a></li>
        <li style="font-size: 17px"><a id="d5" href="#" style="color: silver;">待使用　　　　　　　></a></li>
        <li style="font-size: 17px"><a id="d6" href="#" style="color: silver;">待评价　　　　　　　></a></li>
        <li style="font-size: 17px"><a id="d7" href="#" style="color: silver;">退款售后　　　　　　></a></li>
        <li style="font-size: 20px"><a id="d8" href="#" style="color: black;">我的收藏</a></li>
        <li style="font-size: 17px"><a id="d9" href="#" style="color: silver;">收藏的商家　　　　　></a></li>
        <li style="font-size: 17px"><a id="d10" href="#" style="color: silver;">收藏的团购　　　　　></a></li>
        <li style="font-size: 20px"><a id="d11" href="personMessage.jsp" style="color: black;">个人信息</a></li>
        <li style="font-size: 17px"><a id="d12" href="#" style="color: silver;">账户设置　　　　　　></a></li>
    </ul>

</div>
hahah${username}哈哈哈
<div style="height: 200px;width: 800px;background:yellow;float: left;margin-left: 15px">
    <img style="width: 100px;height: 100px;float: left;margin-top: 35px;margin-left: 30px" alt="" src="${img }">
    <div style="margin-top: 65px;margin-left: 150px"><a style="text-decoration: none" href="user/selectuser">${username }</a></div>

    <a style="margin-left: 460px;text-decoration: none" href="/getPersonMessage?username=${username}">个人信息设置></a>
</div>
<div style="height: 50px;width: 800px;float: left;margin-left: 15px;margin-top: 50px">
    <a href="order/orderfenye?pageNow=1" style="margin-top: 70px;margin-left: 70px">全部订单</a>
    <a style="margin-top: 70px;margin-left: 70px">待付款</a>
    <a style="margin-top: 70px;margin-left: 70px">待使用</a>
    <a style="margin-top: 70px;margin-left: 70px">待评论</a>
    <a style="margin-top: 70px;margin-left: 70px">退款售后</a>
</div>

<div style="height: 600px;width: 800px;float: left;margin-left: 15px;margin-top: 1px;border: 1px solid silver;">




</div>
</body>
</html>
