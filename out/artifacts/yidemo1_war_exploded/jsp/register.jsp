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
    <style>
        * {
            margin: 0;
            padding: 0;
        }
        body {
            background-color: #ff6700;
            font-size: 14px;
        }
        .pop {
            position: fixed;
            margin: 10% 35%;
        }
        .pop-wp {
            width: 280px;
            background: #FFF;
            padding: 30px 50px 50px;
        }
        .pop-close {
            top: -12px;
            width: 30px;
            right: -12px;
            height: 30px;
            color: #ccc;
            font-size: 20px;
            position: absolute;
            text-align: center;
            border-radius: 50%;
            background: #444;
            display: inline-block;
        }
        .pop-close:hover {
            background: #111;
        }
        .pop-title {
            font-size: 24px;
            line-height: 24px;
            margin-bottom: 20px;
        }

        .account-form {
            padding: 0 15px;
            margin-bottom: 40px;
            border: 1px solid #dcdcdc;
        }

        .account-input {
            width: 100%;
            border: none;
            height: 30px;
            outline: none;
            display: block;
            margin: 10px 0;
        }
        .account-line {
            width: 100%;
            height: 1px;
            overflow: hidden;
            background: #dcdcdc;
        }
        .account-btn {
            width: 100%;
            border: none;
            height: 45px;
            outline: none;
            color: #FFF;
            cursor: pointer;
            font-size: 14px;
            text-align: center;
            background: #eb4235;
        }
        .account-btn:hover {
            background: #d1271a;
        }
        .pop-close {
            text-decoration: none;
        }
    </style>
    <%--<script type="text/javascript" src="../js/jquery-2.1.4.js"></script>
    <script type="text/javascript" src="../js/register.js" ></script>--%>


</head>
<body>
<div class="pop">
    <div class="pop-wp">
        <a href="../toMain?pageNow=1" class="pop-close">商家中心</a>
        <div class="pop-title">用户注册</div>
        <form action="/register" method="post">
            <div class="account-form">
                <input id="tel" name="tel" type="text" placeholder="昵称" class="account-input">
                <div id="password" name="password" class="account-line"></div>
                <input type="password" name="password" placeholder="密码" class="account-input">
                <div class="account-line"></div>
                <input id="password1" name="" type="password" placeholder="确认密码" class="account-input">
                <div class="account-line"></div>
                <div style="width: 100%;height: 10px"></div>
                <input type="radio" name="status" value="0"/>普通用户
                <input type="radio" name="status" value="1"/>商家
                <div style="width: 100%;height: 10px"></div>
            </div>
            <button type="submit" class="account-btn">注册</button>
        </form>
    </div>
</div>
</body>
</html>
