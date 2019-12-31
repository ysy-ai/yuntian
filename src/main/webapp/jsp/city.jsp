<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86132
  Date: 2019/12/10
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>云天-城市搜索</title>
    <script type="text/javascript">
        var proList = ["河南", "浙江", "山东", "四川", "江苏", "广东"];
        var allCityList = [
            ["郑州", "洛阳", "开封", "信阳", "巩义", "息县", "固始县", "罗山县", "商城县", "潢川县"],
            ["杭州", "西塘", "乌镇", "嘉善", "海宁", "安吉", "嘉兴", "海盐", "平湖", "温州"],
            ["青岛", "济南", "枣庄", "烟台", "日照", "菏泽", "聊城", "泰安", "淄博", "龙口"],
            ["成都", "巴中", "宜宾", "自贡", "攀枝花", "雅安", "广安", "广汉", "乐山", "凉山"],
            ["无锡", "南京", "昆山", "苏州", "张家港", "江阴", "连云港", "盐城", "海门", "扬州"],
            ["广州", "佛山", "惠州", "珠海", "东莞", "汕头", "中山", "湛江", "韶关", "汕尾"]
        ];

        function f1() {
            var pro = document.getElementById("province");
            pro.length = proList.length + 1;
            for (var i = 1; i < pro.length; i++) {
                pro[i].innerHTML = proList[i - 1];
                pro[i].value = i;
            }
        }

        function f2() {
            var city = document.getElementById("city");
            var pro = document.getElementById("province");
            city.value = "";
            var cityList = allCityList[pro.value - 1];
            city.length = cityList.length + 1;
            for (var i = 1; i < city.length; i++) {
                city[i].innerText = cityList[i - 1];
                city[i].value = cityList[i - 1];
            }
        }
    </script>
    <style type="text/css">
        #a1,#a2,#a3,#a4,#a5,#a6,#a7,#a8,#a9,#a10,#a11,#a12{
            text-decoration: none;
            color: black;
        }
    </style>
</head>
<body>
<jsp:include page="main.jsp"></jsp:include>
<br><br>
<div style="margin-left: 350px;width: 1100px;height: 1000px;border: #A9A9A9 solid 1px">
    <div style="width: 1000px;height: 100px;margin-left: 50px;border-bottom: #A9A9A9 solid 1px;line-height: 100px;float: left">
        <form action="getCityname?cityname=null" method="post" >
            按省份选择：
            <select style="height: 30px;width: 100px" name="province" id="province" onfocus="f1()" onchange="f2()">
                <option value="">选择省份</option>
            </select> 省
            <select style="height: 30px;width: 100px" name="cityname1" id="city">
                <option value="">选择城市</option>
            </select> 市/区
            <input type="submit" value="搜索">　　　
            <input type="submit" value="直接搜索">:
            <input style="height: 30px;width: 130px" type="text" name="cityname1" value="">
        </form>
    </div>

    <div style="width: 1000px;height: 100px;margin-left: 50px;border-bottom: #A9A9A9 solid 1px;line-height:100px;float: left">
        热门城市：<a id="a1" href="getCityname?cityname=息县" style="margin-left: 25px">息县</a> <a id="a2" href="getCityname?cityname=信阳" style="margin-left: 25px">信阳</a><a id="a3" href="getCityname?cityname=嘉兴" style="margin-left: 25px">嘉兴</a><a id="a4" href="getCityname?cityname=杭州" style="margin-left: 25px">杭州</a><a id="a5" href="getCityname?cityname=成都" style="margin-left: 25px">成都</a>
    </div>

    <div style="width: 1000px;height: 100px;margin-left: 50px;border-bottom: #A9A9A9 solid 1px;line-height:100px;float: left">
        最近访问：<a id="a6" href="getCityname?cityname=${city1}" style="margin-left: 25px">${city1}</a>
    </div>

    <div style="width: 1000px;height: 50px;margin-left: 50px;line-height:50px;float: left">按城市选择：</div>
    <div style="width: 1000px;height: 100px;margin-left: 50px;line-height:100px;float: left">
        河南：<c:forEach items="${henan}" var="henan">
               <a id="a7" href="getCityname?cityname=${henan.cityname}" style="margin-left: 25px">${henan.cityname}</a>
              </c:forEach>
    </div>

    <div style="width: 1000px;height: 100px;margin-left: 50px;line-height:100px;float: left">
    浙江：<c:forEach items="${zhejiang}" var="zhejiang">
           <a id="a8" href="getCityname?cityname=${zhejiang.cityname}" style="margin-left: 25px">${zhejiang.cityname}</a>
          </c:forEach>
    </div>

    <div style="width: 1000px;height: 100px;margin-left: 50px;line-height:100px;float: left">
    山东：<c:forEach items="${shandong}" var="shandong">
           <a id="a9" href="getCityname?cityname=${shandong.cityname}" style="margin-left: 25px">${shandong.cityname}</a>
          </c:forEach>
    </div>

    <div style="width: 1000px;height: 100px;margin-left: 50px;line-height:100px;float: left">
    四川：<c:forEach items="${sichuan}" var="sichuan">
           <a id="a10" href="getCityname?cityname=${sichuan.cityname}" style="margin-left: 25px">${sichuan.cityname}</a>
          </c:forEach>
    </div>

    <div style="width: 1000px;height: 100px;margin-left: 50px;line-height:100px;float: left">
    江苏：<c:forEach items="${jiangsu}" var="jiangsu">
           <a id="a11" href="getCityname?cityname=${jiangsu.cityname}" style="margin-left: 25px">${jiangsu.cityname}</a>
          </c:forEach>
    </div>

    <div style="width: 1000px;height: 100px;margin-left: 50px;line-height:100px;float: left">
    广东：<c:forEach items="${guangdong}" var="guangdong">
            <a id="a12" href="getCityname?cityname=${guangdong.cityname}" style="margin-left: 25px">${guangdong.cityname}</a>
          </c:forEach>
    </div>

    </div>
</div>
</body>
</html>
