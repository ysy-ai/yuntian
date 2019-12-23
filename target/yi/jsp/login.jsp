<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>云天-登录</title>
    <link rel="stylesheet" type="text/css" href="../css/login.css" />
    <script type="text/javascript" src="../js/jquery-2.1.4.js"></script>
    <%--<script type="text/javascript" src="../js/login.js"></script>--%>
</head>
<body>
<div class="music-lgin">

    <div class="music-lgin-all">
        <!--左手-->
        <div class="music-lgin-left ovhd">
            <div class="music-hand">
                <div class="music-lgin-hara"></div>
                <div class="music-lgin-hars"></div>
            </div>
        </div>

        <!--脑袋-->
        <div class="music-lgin-dh">
            <div class="music-lgin-alls">
                <div class="music-lgin-eyeleft">
                    <div class="music-left-eyeball yeball-l"></div>
                </div>
                <div class="music-lgin-eyeright">
                    <div class="music-right-eyeball yeball-r"></div>
                </div>
                <div class="music-lgin-cl"></div>
            </div>
            <!--鼻子-->
            <div class="music-nose"></div>
            <!--嘴-->
            <div class="music-mouth music-mouth-ds"></div>
            <!--肩-->
            <div class="music-shoulder-l">
                <div class="music-shoulder"></div>
            </div>
            <div class="music-shoulder-r">
                <div class="music-shoulder"></div>
            </div>
            <!--消息框-->
            <div class="music-news">来了,老弟！</div>
        </div>

        <!--右手-->
        <div class="music-lgin-right ovhd">
            <div class="music-hand">
                <div class="music-lgin-hara"></div>
                <div class="music-lgin-hars"></div>
            </div>
        </div>

    </div>

    <!--1-->
    <form action="${pageContext.request.contextPath}/validatePassword" method="post">
        <div class="music-lgin-text">

            <label for="user_name"></label><input id="user_name" name="tel" class="inputname inputs" type="text" placeholder="用户名" value=""/>
        </div>
        <!--2-->
        <div class="music-lgin-text">
            <label>
                <input type="password" name="password" class="mima inputs" placeholder="密码" value=""/>
                <p>${error}</p>
            </label>
        </div>
        <!--3-->
        <div class="music-lgin-text">
            <input class="music-qd inputs" type="submit" value="登录" />
        </div>
        　　　　　<a href="register.jsp" style="text-decoration: none">　<strong id="d1"></strong></a>

    </form>
    <p class="message">　　　　　　还没有账户? <a style="text-decoration: none;color: black;" href="register.jsp" style="color: white">立刻创建</a></p>
</div>

<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript">
    //眼睛 密码部分
    $(".mima").focus(function() {
        $(".music-lgin-left").addClass("left-dh").removeClass("rmleft-dh");
        $(".music-lgin-right").addClass("right-dh").removeClass("right-rmdh");
        $(".music-hand").addClass("no");
    }).blur(function() {
        $(".music-lgin-left").removeClass("left-dh").addClass("rmleft-dh");
        $(".music-lgin-right").removeClass("right-dh").addClass("right-rmdh");
        $(".music-hand").removeClass("no");

    });
    //点击小人出来
    $(".inputname").focus(function() {
        $(".music-lgin-all").addClass("block");
        $(".music-news").addClass("no")
    });
    //点击小人消失

              $(".music-qd").focus(function(){
              	$(".music-lgin-all").removeClass("block")
              })
</script>
</body>
</html>
