<%--
  Created by IntelliJ IDEA.
  User: 86132
  Date: 2020/2/25
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>用户注销</title>
    <script>
        var t = 3;//设定跳转的时间
        setInterval("refer()", 1000); //启动1秒定时
        function refer() {
            if (t == 0) {
                location = "index.jsp"; //#设定跳转的链接地址
            }
            document.getElementById('show').innerHTML = "" + t + "秒后自动跳转..."; // 显示倒计时
            t--; // 计数器递减
        }
    </script>
</head>

<body>
<div style="text-align: center;align-items: center">
<a href="index.jsp">删除成功，立即退出...</a>
<br>
<span id="show">4秒后自动退出...</span>
</div>
</body>
</html>
