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
        .demo {
            width: 100%;
            height: 100%;
            background-image: url(https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1582475385647&di=705355b2d7925b512b7b7b61bbd59b23&imgtype=0&src=http%3A%2F%2Fattachments.gfan.com%2Fforum%2Fattachments2%2F201306%2F13%2F161859aswbscnswnr11rlb.jpg);
        }
        .content {
            position: absolute;
            top: 15%;
            left: 20%;
        }
    </style>
</head>
<body>
 <%--   <div style="height: 40px;background: #F8F8F8;">
        <a href="jsp/registerRestaurant.jsp">注册餐馆</a>
        <a href="jsp/index.jsp">退出</a>
        <a href="">餐馆详情</a>
    </div>--%>
<div class="demo">
    <div class="content">
        <h2 class="gradient-text gradient-text-one">欢</h2>
        <h2 class="gradient-text gradient-text-one">迎</h2>
        <h2 class="gradient-text gradient-text-one">来</h2>
        <h2 class="gradient-text gradient-text-one">到</h2>
        <h2 class="gradient-text gradient-text-one">商</h2>
        <h2 class="gradient-text gradient-text-one">城</h2>
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
        <h2 class="gradient-text gradient-text-one"> </h2>
        <a href="index.jsp">
        <h6 style="font-size: 50px" class="gradient-text gradient-text-one">退</h6>
        <h6 style="font-size: 50px" class="gradient-text gradient-text-one">出</h6>
        </a><br>
    </div>
</div>
</form>
</body>
</html>
