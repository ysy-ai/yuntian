<%--
  Created by IntelliJ IDEA.
  User: 86132
  Date: 2019/12/9
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>云天美食</title>
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
            transform: skew(30deg, -60deg);
            font-size: 100px;
        }
        .content {
            position: absolute;
            top: 35%;
            left: 20%;
            animation: move 3s ease-in 2s 2;
        }
        @keyframes move {
            0% {
                transform: translate(0, 0);
            }
            25% {
                transform: rotate(180deg) translate(0, 0);
            }
            50% {
                transform: scale(2, 4) translate(0, 0);
            }
            100% {
                transform: translate(0, 0);
            }
        }
    </style>
</head>
<body>
<a href="toMain?pageNow=1"><img src="images/yi.jpg" style="width: 100%;height: 100%" alt=""></a>
<div class="demo">
    <div class="content">
        <h2 class="gradient-text gradient-text-one">欢</h2>
        <h2 class="gradient-text gradient-text-one">迎</h2>
        <h2 class="gradient-text gradient-text-one">来</h2>
        <h2 class="gradient-text gradient-text-one">到</h2>
        <h2 class="gradient-text gradient-text-one">云</h2>
        <h2 class="gradient-text gradient-text-one">天</h2>
        <h2 class="gradient-text gradient-text-one">美</h2>
        <h2 class="gradient-text gradient-text-one">食</h2>
    </div>
</div>
</body>
</html>
