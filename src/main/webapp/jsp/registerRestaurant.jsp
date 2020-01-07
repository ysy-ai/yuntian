<%--
  Created by IntelliJ IDEA.
  User: 86132
  Date: 2019/12/31
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>餐馆注册</title>
</head>
<body>
<form action="/registerRestaurant" method="post" enctype="multipart/form-data">
    餐馆图片:<input type="file" name="file" style="height: 50px;width: 120px"/><br>
    餐馆名称:<input type="text" name="rname"/><br>
    餐馆地址:<input type="text" name="address"/><br>
    餐馆电话:<input type="text" name="tel"/><br>
    人均价格:<input type="text" name="perprice"/><br>
    <input type="submit" value="注册">
</form>
${success}
</body>
</html>
