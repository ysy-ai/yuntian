<%--
  Created by IntelliJ IDEA.
  User: 86132
  Date: 2020/1/3
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="main.jsp"></jsp:include><br><br>

<div style="border: 1px solid silver;width: 800px;height: 100px;line-height:100px;margin-left: 500px;margin-top: 10px;">
    <div style="float: left;font-size: 21px">项目:${name }</div>
    <div style="float: left;margin-left: 350px;color: red">应付金额￥</div>
    <div style="float: left;font-size: 30px;color: red;margin-top: -5px">${total }</div>
</div>

<div style="border: 1px solid silver;width: 800px;height: 400px;margin-left: 500px;margin-top: 10px;">
    <div style="text-align:center;width: 120px;height: 30px;line-height: 30px;border: 1px solid silver;margin-left: 20px;margin-top: 30px;float: left;">支付宝/微信</div>
    <div style="text-align:center;width: 120px;height: 30px;line-height: 30px;border: 1px solid silver;margin-top: 30px;float: left">个人网银支付</div>
    <div style="width: 500px;height: 30px;border-bottom:1px solid silver;margin-top: 31px;float: left">
        <div style="float: left;margin-top: 10px;margin-left: 380px;font-size: 5px">支付帮助</div>
        <div style="float: left;margin-top: 10px;margin-left: 15px;font-size: 5px">意见反馈</div>
    </div>
    <div style="float: left;margin-top: 20px">
        <form action="payOrder" method="post">
            <div style="float: left;margin-left: 10px;margin-top: 5px"><input type="radio" name="radio" value="微信" checked="checked"></div>
            <div style="float: left;margin-left: 10px;border: 1px solid silver;"><img alt="" src="images/weixin.png"></div>
            <div style="float: left;margin-left: 20px;margin-top: 5px"><input type="radio" name="radio" value="支付宝"></div>
            <div style="float: left;margin-left: 10px;border: 1px solid silver;"><img alt="" src="images/zhi.png"></div>
            <div style="float: left;margin-left: 350px;color: red;margin-top: 210px;margin-left: 210px">支付￥</div>
            <div style="float: left;font-size: 30px;color: red;margin-top: 195px">${total }</div>
            <input style="margin-left:600px;width: 130px;height: 50px;border-radius: 25px;background: orange" type="submit" value="去付款">
        </form>
    </div>


</div>
</body>
</html>
