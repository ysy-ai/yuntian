$(function(){
	alert("222222");
	$("#tel").blur(function(){
		alert("111111");
		var tel=document.getElementById("tel").value;
		alert(tel);
		var telReg=/^1\d{10}$/;
		if(!telReg.test(tel)){
			 alert("请正确填写电话号码，例如:13415764179");
		}
		
		/*$.ajax({
			type:'post',
			url:'user/zhuce',
			contentType:'application/x-www-form-urlencoded;charset=utf-8',
			data:'tel='+tel,
			success:function(responseText){
				$("#d1").html(responseText);
			}

		});*/

	});
	
	$("#password1").blur(function(){
		var password=document.getElementById("password").value;
		var password1=document.getElementById("password1").value;
		if(password!=password1){
			alert("两次密码不一致，请重新输入");
		}
		
	});
	
});