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
    <title>云天-注册</title>

    <style type="text/css">

        .form1{
            position: absolute;
            top:300px;
            left:800px;
            line-height: 40px;
        }
        * {
            margin: 0;
            padding: 0;
            list-style: none;
        }

        body {
            background: #032b39;
            height: 100vh;
        }

        /*.drive,
        .shadows {
            position: fixed;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
        }*/

        .drive li {
            position: absolute;
            left: 50%;
            top: 50%;
            border: 1px solid rgba(255, 255, 255, 0.15);
            box-shadow: 0 1vw 3vw rgba(0, 0, 0, 0.5) inset;
            width: 100vw;
            height: 100vh;
            animation: drive 10s linear infinite;
            animation-direction: reverse;
        }

        .shadows li {
            position: absolute;
            left: 50%;
            top: 50%;
            background: #000;
            width: 100vw;
            height: 100vh;
            animation: shadows 10s linear infinite;
            animation-direction: reverse;
        }

        .drive li:nth-child(1) {
            animation-delay: 0s;
        }

        .drive li:nth-child(2) {
            animation-delay: -1s;
        }

        .drive li:nth-child(3) {
            animation-delay: -2s;
        }

        .drive li:nth-child(4) {
            animation-delay: -3s;
        }

        .drive li:nth-child(5) {
            animation-delay: -4s;
        }

        .drive li:nth-child(6) {
            animation-delay: -5s;
        }

        .drive li:nth-child(7) {
            animation-delay: -6s;
        }

        .drive li:nth-child(8) {
            animation-delay: -7s;
        }

        .drive li:nth-child(9) {
            animation-delay: -8s;
        }

        .drive li:nth-child(10) {
            animation-delay: -9s;
        }

        .shadows li:nth-child(1) {
            animation-delay: 0s;
        }

        .shadows li:nth-child(2) {
            animation-delay: -1s;
        }

        .shadows li:nth-child(3) {
            animation-delay: -2s;
        }

        .shadows li:nth-child(4) {
            animation-delay: -3s;
        }

        .shadows li:nth-child(5) {
            animation-delay: -4s;
        }

        .shadows li:nth-child(6) {
            animation-delay: -5s;
        }

        .shadows li:nth-child(7) {
            animation-delay: -6s;
        }

        .shadows li:nth-child(8) {
            animation-delay: -7s;
        }

        .shadows li:nth-child(9) {
            animation-delay: -8s;
        }

        .shadows li:nth-child(10) {
            animation-delay: -9s;
        }

        @keyframes drive {
            0% {
                transform: translate(-50%, -50%) scale(1.05) rotate(0deg);
            }
            100% {
                transform: translate(-50%, -50%) scale(0) rotate(-45deg);
            }
        }

        @keyframes shadows {
            0% {
                transform: translate(-50%, -50%) scale(1.05) rotate(0deg);
                opacity: 0;
            }
            100% {
                transform: translate(-50%, -50%) scale(0) rotate(-45deg);
                opacity: 0.25;
            }
        }

    </style>
    <script type="text/javascript" src="../js/jquery-2.1.4.js"></script>
    <script type="text/javascript" src="../js/register.js" ></script>


</head>
<body>
<form class="form1" action="/register" method="post">
    手机号：　<label for="tel"></label><input id="tel" type="text" name="tel" value=""><strong id="d1" style="color: red"></strong><br>
    密码：　　<label for="password"></label><input id="password" type="password" name="password" value=""><br>
    确认密码：<label for="password1"></label><input id="password1" type="password" name="" value=""><br>
    用户类型：<input type="radio" name="status" value="0"/>普通用户
    <input type="radio" name="status" value="1"/>商家
    　　　　　　<input type="submit" value="注册">
</form>
</body>
</html>
