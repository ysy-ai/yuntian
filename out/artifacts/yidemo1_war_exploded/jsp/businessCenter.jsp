<%--
  Created by IntelliJ IDEA.
  User: 86132
  Date: 2020/2/20
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商家中心</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
        }
        body,
        html {
            width: 100%;
            height: 100%;
        }
        .gradient-text-one {
            background-image: -webkit-linear-gradient(bottom, red, green, pink);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
        }
        .gradient-text {
            float: left;
            width: 140px;
            height: 100px;
            font-size: 75px;
            text-align: left;
            text-indent: 30px;
            position: relative;
            font-weight: bolder;
            transition: all 0.25s;
        }
        .gradient-text:hover {
            transform: skew(30deg,-60deg);
            font-size: 100px;
        }
        .content {
            position: absolute;
            top: 10%;
            left: 20%;
        }
    </style>
</head>
<body>
<a><img src="images/center.jpg" style="width: 100%;height: 100%" alt=""></a>
<div class="demo">
    <div class="content">
        <h2 class="gradient-text gradient-text-one">欢</h2>
        <h2 class="gradient-text gradient-text-one">迎</h2>
        <h2 class="gradient-text gradient-text-one">来</h2>
        <h2 class="gradient-text gradient-text-one">到</h2>
        <h2 class="gradient-text gradient-text-one">商</h2>
        <h2 class="gradient-text gradient-text-one">家</h2>
        <h2 class="gradient-text gradient-text-one">中</h2>
        <h2 class="gradient-text gradient-text-one">心</h2><br>
        <h2 class="gradient-text gradient-text-one"> </h2>
        <h2 class="gradient-text gradient-text-one"> </h2>
        <h2 class="gradient-text gradient-text-one"> </h2>
        <a href="jsp/registerRestaurant.jsp">
        <h6 style="font-size: 50px" class="gradient-text gradient-text-one">商</h6>
        <h6 style="font-size: 50px" class="gradient-text gradient-text-one">家</h6>
        <h6 style="font-size: 50px" class="gradient-text gradient-text-one">注</h6>
        <h6 style="font-size: 50px" class="gradient-text gradient-text-one">册</h6><br>
        </a>
        <h2 class="gradient-text gradient-text-one"> </h2>
        <h2 class="gradient-text gradient-text-one"> </h2>
        <h2 class="gradient-text gradient-text-one"> </h2>
        <h2 class="gradient-text gradient-text-one"> </h2>
        <h2 class="gradient-text gradient-text-one"> </h2>
        <a href="/merchantDetails">
        <h6 style="font-size: 50px" class="gradient-text gradient-text-one">商</h6>
        <h6 style="font-size: 50px" class="gradient-text gradient-text-one">家</h6>
        <h6 style="font-size: 50px" class="gradient-text gradient-text-one">详</h6>
        <h6 style="font-size: 50px" class="gradient-text gradient-text-one">情</h6>
        </a><br>
        <h2 class="gradient-text gradient-text-one"> </h2>
        <h2 class="gradient-text gradient-text-one"> </h2>
        <h2 class="gradient-text gradient-text-one"> </h2>
        <h2 class="gradient-text gradient-text-one"> </h2>
        <h2 class="gradient-text gradient-text-one"> </h2>
        <a href="deleteUser">
        <h6 style="font-size: 50px" class="gradient-text gradient-text-one">商</h6>
        <h6 style="font-size: 50px" class="gradient-text gradient-text-one">家</h6>
        <h6 style="font-size: 50px" class="gradient-text gradient-text-one">注</h6>
        <h6 style="font-size: 50px" class="gradient-text gradient-text-one">销</h6>
        </a><br>
        <h2 class="gradient-text gradient-text-one"> </h2>
        <h2 class="gradient-text gradient-text-one"> </h2>
        <h2 class="gradient-text gradient-text-one"> </h2>
        <h2 class="gradient-text gradient-text-one"> </h2>
        <h2 class="gradient-text gradient-text-one"> </h2>
        <h2 class="gradient-text gradient-text-one"> </h2>
        <a href="../index.jsp">
        <h6 style="font-size: 50px" class="gradient-text gradient-text-one">退</h6>
        <h6 style="font-size: 50px" class="gradient-text gradient-text-one">出</h6>
        </a><br>
    </div>
</div>
</form>
</body>
</html>
