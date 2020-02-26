<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86132
  Date: 2020/2/24
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>商家详情</title>
</head>
<body>
<h3 style="width: 100px;height: 20px;margin-left: 350px;float: left">旗舰店</h3>
<h3 style="width: 100px;height: 20px;margin-left: 510px;float: left"><a style="text-decoration: none;color: black" href="businesscenter">商家中心</a></h3>
<div style="margin-left: 350px;width: 700px;height: 700px">
    <c:forEach items="${list }" var="restaurant">
    <div style="width: 700px;height:250px;border-bottom: 1px solid silver;float: left;margin-top: 20px">
    <a href="showDish?rname=${restaurant.rname }&yi=i"><img style="width:250px;height: 250px;float: left;" src="${restaurant.url}"/></a>
    <div style="width:250px;height: 250px;float: left;">
    <ul style="list-style: none;">
    <li><h3>${restaurant.rname }</h3></li>
    <li>人均:${restaurant.perprice }</li>
    <li>评分:${restaurant.score }</li>
    <li>评论数量:${restaurant.commentcount }条评论</li>
    <li>地址:${restaurant.address }</li>
    <li>电话:${restaurant.tel }</li>
    </ul>
    <a style="float: left;margin-left: 380px;text-decoration: none;color: black" href="deleteRestaurant?id=${restaurant.id }&tel=${restaurant.tel }"><h3 style="width: 80px;height: 30px">注销</h3></a>
    </div>
        </c:forEach>
        <h3 style="float: left;margin-left: 250px">${isEmpty}</h3>
    </div>
</body>
</html>
