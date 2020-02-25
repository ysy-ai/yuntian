<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86132
  Date: 2019/12/11
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>云天-主界面</title>
</head>
<body>
<jsp:include page="main.jsp"></jsp:include>
<div style="margin-left: 350px;margin-top: 20px;width: 1100px;height: 60px;line-height: 60px;float: left">${city}云天>${city}美食</div>
<div style="margin-left: 350px;width: 1100px;height: 260px;border: #A9A9A9 solid 1px;float: left">
    <div style="margin-left: 20px;width: 130px;height: 130px;line-height: 130px;float: left">分类</div>
    <div style="width: 950px;height: 130px;line-height: 130px;border-bottom: #A9A9A9 solid 1px;float: left">
        <c:forEach var="cuidsines" items="${cuidsines}">
            <a href="getRestauantBycuidisine?pageNow=1&name=${cuidsines.cname}&sign=cu"
               style="width: 80px;height: 30px;float: left;text-decoration: none;color: black">${cuidsines.cname}</a>
        </c:forEach>
    </div>
    <div style="margin-left: 20px;width: 130px;height: 130px;line-height: 130px;float: left">地区</div>
    <div style="width: 950px;height: 130px;line-height: 130px;float: left">
        <c:forEach var="cities" items="${cities}">
            <a href="getRestauantBycuidisine?pageNow=1&name=${cities.cityname}&sign=ci"
               style="width: 80px;height: 30px;float: left;text-decoration: none;color: black">${cities.cityname}</a>
        </c:forEach>
    </div>
</div>

<div style="margin-left: 350px;width: 700px;height: 700px">
    <div style="height: 60px;width: 700px;line-height: 60px;float: left">
        <a>默认</a>
    </div>
            <c:forEach items="${fenye.list }" var="restaurant">
                <div style="width: 700px;height:250px;border-bottom: 1px solid silver;float: left;margin-top: 20px">
                        <a href="showDish?rname=${restaurant.rname }&yi='y'"><img style="width:250px;height: 250px;float: left;" src="${restaurant.url}"/></a>
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

            <div style="margin-top: 30px;margin-top: 20px;float: left">
            <c:if test="${fenye.pageNow>1 }">
                [<a href="getRestauantBycuidisine?pageNow=${fenye.pageNow-1 }">上一页</a>]
            </c:if>

            <c:if test="${fenye.page<=10 }">
                <c:set var="begin" value="1"/>
                <c:set var="end" value="${fenye.page}"/>
            </c:if>
            <c:forEach var="i" begin="${begin }" end="${end }">
                <c:if test="${fenye.pageNow eq i }">
                    ${i }
                </c:if>
                <c:if test="${!(fenye.pageNow eq i )}">
                    [<a href="getRestauantBycuidisine?pageNow=${i }">${i }</a>]
                </c:if>
            </c:forEach>

            <c:choose>
                <c:when test="${fenye.pageNow>=fenye.page }">
                    [<a href="getRestauantBycuidisine?pageNow=1">下一页</a>]
                </c:when>
                <c:otherwise>
                    [<a href="getRestauantBycuidisine?pageNow=${fenye.pageNow+1 }">下一页</a>]
                </c:otherwise>
            </c:choose>
        </div>
</div>
<div style="margin-left: 350px;width: 700px;height: 200px;float: left"></div>
</body>
</html>
