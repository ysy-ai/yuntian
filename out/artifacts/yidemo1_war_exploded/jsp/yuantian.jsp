<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86132
  Date: 2019/12/13
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>云天-云天</title>
    <style type="text/css">
        #d1, #d2, #d3, #d4, #d5, #d6, #d7, #d8, #d9, #d10, #d11, #d12 {
            text-decoration: none;
        }

        ul li #d1.h:HOVER {
            color: red;
        }

    </style>
</head>
<body>
<jsp:include page="main.jsp"></jsp:include>
<br>
<div style="height: 600px;width: 300px;border: 1px solid silver;float: left;margin-left: 350px">
    <ul style="list-style: none;line-height: 30px;height: 30px">
        <li style="font-size: 20px"><a id="d1" href="#" style="color: black;">我的云天</a></li>
        <li style="font-size: 20px"><a id="d2" href="#" style="color: black;">我的订单</a></li>
        <li style="font-size: 17px"><a id="d3" href="allOrder?status1=3" style="color: silver;">全部订单　　　　　　></a></li>
        <li style="font-size: 17px"><a id="d4" href="allOrder?status1=1" style="color: silver;">待付款　　　　　　　></a></li>
        <li style="font-size: 17px"><a id="d5" href="noused" style="color: silver;">待使用　　　　　　　></a></li>
        <li style="font-size: 17px"><a id="d6" href="nocomment" style="color: silver;">待评价　　　　　　　></a></li>
        <li style="font-size: 17px"><a id="d7" href="refund" style="color: silver;">退款售后　　　　　　></a></li>
        <li style="font-size: 20px"><a id="d8" href="#" style="color: black;">我的收藏</a></li>
        <li style="font-size: 17px"><a id="d9" href="#" style="color: silver;">收藏的商家　　　　　></a></li>
        <li style="font-size: 17px"><a id="d10" href="#" style="color: silver;">收藏的团购　　　　　></a></li>
        <li style="font-size: 20px"><a id="d11" href="personMessage.jsp" style="color: black;">个人信息</a></li>
        <li style="font-size: 17px"><a id="d12" href="personMessage.jsp" style="color: silver;">账户设置　　　　　　></a></li>
    </ul>

</div>
<div style="height: 200px;width: 800px;background:#FFC500;float: left;margin-left: 15px">
    <img style="width: 100px;height: 100px;float: left;margin-top: 35px;margin-left: 30px;border-radius: 50%" alt=""
         src="${users1.headPortrait}">
    <div style="margin-top: 65px;margin-left: 150px"><a style="text-decoration: none;color: black"
                                                        href="getPersonMessage">${username }</a></div>

    <a style="margin-left: 460px;text-decoration: none;color: black" href="getPersonMessage">个人信息设置></a>
</div>
<div style="height: 50px;width: 800px;float: left;margin-left: 15px;margin-top: 50px">
    <a id="order" href="allOrder?status1=3" style="margin-top: 70px;margin-left: 70px;text-decoration: none;color: black">全部订单</a>
    <a id="pay" href="allOrder?status1=1" style="margin-top: 70px;margin-left: 70px;text-decoration: none;color: black">待付款</a>
    <a id="used" href="noused" style="margin-top: 70px;margin-left: 70px;text-decoration: none;color: black;">待使用</a>
    <a id="comment" href="nocomment" style="margin-top: 70px;margin-left: 70px;text-decoration: none;color: black;">待评论</a>
    <a id="shouhou" href="refund" style="margin-top: 70px;margin-left: 70px;text-decoration: none;color: black;">退款售后</a>
</div>

<div style="height: 600px;width: 800px;float: left;margin-left: 15px;margin-top: 1px;border: 1px solid silver;">
    <div style="font-size: 20px;color: black;float: left;margin-top: 20px;margin-left: 15px;">猜你喜欢</div>
    <div style="font-size: 14px;color: silver;float: left;margin-left: 20px;margin-top: 30px">为您甄选最合适的</div>
    <c:forEach items="${fenye.list }" var="restaurant">
        <div style="width: 700px;height:250px;border-bottom: 1px solid silver;float: left;margin-top: 20px;margin-left: 15px;">
            <a href="showDish?rname=${restaurant.rname }"><img style="width:250px;height: 250px;float: left;" src="${restaurant.url}"/></a>
            <div style="width:250px;height: 250px;float: left;">
                <ul style="list-style: none;">
                    <li><h3>${restaurant.rname }</h3></li>
                    <li>人均:${restaurant.perprice }</li>
                    <li>评分:${restaurant.score }</li>
                    <li>评论数量:${restaurant.commentcount }条评论</li>
                    <li>地址:${restaurant.address }</li>
                    <li>电话:${restaurant.tel }</li>
                </ul>
            </div>
        </div>
    </c:forEach>

    <c:forEach var="allOrder" items="${list}">
        <div style="width: 800px;float: left;margin-top: 20px;margin-left: 60px">
        <img src="${allOrder.pictureUrl}" style="width: 100px;height: 100px;float: left;border-radius: 5%">
            <div style="float: left;font-size: 10px;margin-left: 10px">
        <div style="font-size: 17px;color: #1a252f;margin-top: 20px">${allOrder.dishname}</div>
        餐馆：${allOrder.rname}<br>
        数量：${allOrder.count}<br>
        下单时间：${allOrder.time}
            </div>
            <div style="float: left;margin-left: 140px;font-size: 10px;margin-top: 50px">
        总价：￥${allOrder.total}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        ${allOrder.status}
        </div>
        </div>
        <div style="width: 680px;float: left;margin-left: 60px;margin-top: 20px;border: 0.5px silver solid"></div>
    </c:forEach>

    </div>

</div>
</body>
</html>
