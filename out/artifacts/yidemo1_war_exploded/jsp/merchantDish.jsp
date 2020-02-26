<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86132
  Date: 2020/2/24
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>商家详情-菜单</title>
</head>
<body>
<div style="margin-left: 500px;margin-top: 10px;width: 800px;line-height: 60px;float: left">
    <h4 style="float: left;height: 30px">菜单</h4>
    <h4 style="float: left;height: 30px;margin-left: 580px;text-decoration: none;color: black"><a href="insertDish">添加新菜</a></h4>
    <h4 style="float: left;height: 30px;margin-left: 50px;text-decoration: none;color: black"><a href="businesscenter">商家中心</a></h4>
        <table border="1" style="width: 800px;height: 40px;text-align: center">
            <tr>
                <td>图片</td>
                <td>菜名</td>
                <td>价格</td>
                <td>上架/下架</td>
            </tr>
    <c:forEach var="dish" items="${dishes}">
            <tr>
                <td><img style="width: 40px;height: 40px;text-align: center" src="${dish.pictureUrl}"></td>
                <td>${dish.dishName}</td>
                <td>${dish.price}元</td>
                <td><a href="/updateDishStatus?id=${dish.id}&status=${dish.status}&rname=${dish.rname}" style="text-decoration: none;color: black">${dish.statusDetails}</a></td>
            </tr>
        </div>
    </c:forEach>
</table>
</div>
<div style="margin-left: 500px;margin-top: 40px;width: 800px;float: left;border: 1px silver solid;">
    <h3 style="margin-left:50px ">评论区</h3>
    <div style="width: 80px;margin-left: 670px;margin-top: 15px"></div>
    <c:forEach var="comment" items="${comments}">
        <img src="${comment.headurl}" style="width: 60px;height: 60px;border-radius: 50%;float:left;margin-left: 50px">
        <div style="border-bottom: 1px silver solid;width:600px;height: 200px;float:left;margin-left: 20px;margin-top: 20px ">
                ${comment.text}<br>
            <img src="${comment.photourl}">
                    <a  href="/deleteComment?id=${comment.id}" style="width: 100px;height: 30px;float:left;margin-left: 550px;text-decoration: none;color: black"><h3>删除</h3></a>
        </div>

    </c:forEach>
</div>
<div style="height: 200px"></div>
</body>
</html>
