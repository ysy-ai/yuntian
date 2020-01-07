<%--
  Created by IntelliJ IDEA.
  User: 86132
  Date: 2020/1/2
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="main.jsp"></jsp:include>
<br><br>
<table width="700px" border="0" style="margin-left: 500px">
    <tr>
        <td><h4>项目</h4></td>
        <td><h4>单价</h4></td>
        <td><h4>数量</h4></td>
        <td><h4>总价</h4></td>
    </tr>
    <tr>
        <td>${order1.name }</td>
        <td>${prices1 }</td>
        <td><a href="orderManagement?jia=jian&&tel=${order1.tel}&&name=${order1.name }&&price=${prices1 }" id="d3" name="a" style="padding-top: 10px;float: left"><img src="images/jian.png"></a>
            <div id="d2" style="float: left">${countOrder }</div>
            <a style="padding-top: 5px;float: left" href="orderManagement?jia=jia&&tel=${order1.tel}&&name=${order1.name }&&pictureUrl=${order1.pictureUrl}&&price=${prices1 }" id="d1"><img src="images/jia.png"></a></td>
        <td>${total }</td>
    </tr>
</table>

<div style="border-top: 1px solid silver;border-bottom:1px solid silver;width: 650px;height: 30px;margin-left: 500px;margin-top: 10px;"></div>
<div style="border-bottom:1px solid silver;width: 650px;height: 60px;line-height:60px;margin-left: 500px;"><strong
        style="float: right;">应付金额：￥${total }</strong></div>

<div style="width: 650px;height: 60px;margin-left: 500px;"><a href="summitOrder?name=${order1.name }&&total=${total }" style="float: right;margin-top: 30px"><img alt=""
                                                                                                                 src="images/tijiao.jpg"></a>
</div>
</div>
</body>
</html>
