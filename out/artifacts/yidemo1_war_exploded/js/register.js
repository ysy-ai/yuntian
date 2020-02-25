$(function(){
	$("#tel").blur(function(){
		var tel=document.getElementById("tel").value;
		var telReg=/^1\d{10}$/;
		if(!telReg.test(tel)){
			 alert("请正确填写电话号码，例如:13415764179");
		}


	});
	
	$("#password1").blur(function(){
		var password=document.getElementById("password").value;
		var password1=document.getElementById("password1").value;
		if(password!=password1){
			alert("两次密码不一致，请重新输入"+"password"+password+"password1"+password1);
		}
		
	});
	
});