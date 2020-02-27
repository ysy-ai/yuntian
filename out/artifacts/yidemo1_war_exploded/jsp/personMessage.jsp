<%--
  Created by IntelliJ IDEA.
  User: 86132
  Date: 2019/12/13
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>云天-个人信息设置</title>
    <style type="text/css">
        #d1, #d2, #d3, #d4, #d5, #d6, #d7, #d8, #d9, #d10, #d11, #d12 {
            text-decoration: none;
        }

        ul li #d1.h:HOVER {
            color: red;
        }
    </style>
</head>
<body>
<jsp:include page="main.jsp"></jsp:include>
<br><br>
<div style="height: 600px;width: 300px;border: 1px solid silver;float: left;margin-left: 350px">
    <ul style="list-style: none;line-height: 30px;height: 30px">
        <li style="font-size: 20px"><a id="d1" href="#" style="color: black;">我的美团</a></li>
        <li style="font-size: 20px"><a id="d2" href="#" style="color: black;">我的订单</a></li>
        <li style="font-size: 17px"><a id="d3" href="#" style="color: silver;">全部订单　　　　　　></a></li>
        <li style="font-size: 17px"><a id="d4" href="#" style="color: silver;">待付款　　　　　　　></a></li>
        <li style="font-size: 17px"><a id="d5" href="#" style="color: silver;">待使用　　　　　　　></a></li>
        <li style="font-size: 17px"><a id="d6" href="#" style="color: silver;">待评价　　　　　　　></a></li>
        <li style="font-size: 17px"><a id="d7" href="#" style="color: silver;">退款售后　　　　　　></a></li>
        <li style="font-size: 20px"><a id="d8" href="#" style="color: black;">我的收藏</a></li>
        <li style="font-size: 17px"><a id="d9" href="#" style="color: silver;">收藏的商家　　　　　></a></li>
        <li style="font-size: 17px"><a id="d10" href="#" style="color: silver;">收藏的团购　　　　　></a></li>
        <li style="font-size: 20px"><a id="d11" href="insertDish" style="color: black;">个人信息</a></li>
        <li style="font-size: 17px"><a id="d12" href="#" style="color: silver;">账户设置　　　　　　></a></li>
    </ul>

</div>

<div style="height: 605px;width: 1000px;border: 1px solid silver;float: left;margin-left: 15px">

    <div style="width: 750px;height: 100px;line-height: 100px;margin-left: 25px;border-bottom: 1px silver solid">个人信息
        账户设置
    </div>
    <div style="width: 750px;height: 100px;line-height: 100px;margin-left: 25px;border-bottom: 1px silver solid">
        <form action="/upload" method="post" enctype="multipart/form-data">
            选择本地照片:<input type="file" name="file" style="height: 50px;width: 120px"/><input
                style="width: 80px;height: 40px;margin-left: 415px;background-color: sandybrown;" type="submit"
                value="修改"/>
        </form>
        </form>
    </div>
    <form action="updatePersonMessage" method="post">
        <div style="width: 750px;height: 100px;line-height: 100px;margin-left: 25px;border-bottom: 1px silver solid">
            昵称　　<input type="text" name="username" placeholder="${userss.username}"
                       style="height: 50px;width: 500px;margin-left: 20px;border-left: 1px silver solid"/><input
                type="submit" value="修改"
                style="width: 80px;height: 40px;margin-left: 50px;background-color: sandybrown"/>
        </div>
        <div style="width: 750px;height: 100px;line-height: 100px;margin-left: 25px;border-bottom: 1px silver solid">
            生日　　<input type="text" name="birthday" placeholder="${userss.birthday}"
                       style="height: 50px;width: 500px;margin-left: 20px;border-left: 1px silver solid"/><input
                type="submit" value="修改"
                style="width: 80px;height: 40px;margin-left: 50px;background-color: sandybrown"/>
        </div>
        <div style="width: 750px;height: 100px;line-height: 100px;margin-left: 25px;">
            登录密码<input type="text" name="password" placeholder="${userss.password}"
                       style="height: 50px;width: 500px;margin-left: 20px;border-left: 1px silver solid"/><input
                type="submit" value="修改"
                style="width: 80px;height: 40px;margin-left: 50px;background-color: sandybrown"/>
        </div>
    </form>
</div>

</body>
</html>
