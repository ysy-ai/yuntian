<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86132
  Date: 2020/1/2
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>菜品展示</title>
</head>
<body>
<jsp:include page="main.jsp"></jsp:include>
<div style="margin-left: 350px;margin-top: 40px;width: 800px;line-height: 60px;border: 1px silver solid;float: left">
    ${false}
    <c:forEach var="dish" items="${dishes}">
        <div style="width: 760px;height: 220px;margin-top: 20px;margin-left: 20px;border-bottom: 1px silver solid">
            <img style="width: 200px;height: 200px;float: left" src="${dish.pictureUrl}">
            <div style="margin-left: 40px;height: 220px;width: 200px;float: left">
                <ul style="list-style: none">
                    <li>${dish.dishName}</li>
                    <li>￥${dish.price}</li>
                </ul>
            </div>
            <a href="orderManagement?rname=${rname}&&dishName=${dish.dishName}&&price=${dish.price}&&pictureUrl=${dish.pictureUrl}&&jia=jia1"><img
                    style="float: left;margin-left:100px;margin-top: 40px" src="images/qianggou.jpg"></a>
        </div>
    </c:forEach>
</div>

<div style="margin-left: 350px;margin-top: 40px;width: 800px;border: 1px silver solid;float: left">
　　　评论区
    <form action="/comment?rname=${rname}" method="post" enctype="multipart/form-data">
        <input type="text" name="text" value="" style="width: 700px;height: 100px;margin-left: 50px;border-bottom: none"><br>
        <input type="file" name="file" style="height: 50px;width: 700px;margin-left: 50px;margin-top: 10px"/>
        <input type="submit" value="提交" style="width: 80px;height: 30px;margin-left: 670px;margin-top: 15px"/>
    </form>
    <c:forEach var="comment" items="${comments}">
        <img src="${comment.headurl}" style="width: 60px;height: 60px;border-radius: 50%;float:left;margin-left: 50px">
        <div style="border-bottom: 1px silver solid;width:600px;height: 300px;float:left;margin-left: 20px;margin-top: 20px ">
                ${comment.text}<br>
                <img src="${comment.photourl}">
        </div>
    </c:forEach>
</div>
<div style="height: 200px"></div>
</body>
</html>
