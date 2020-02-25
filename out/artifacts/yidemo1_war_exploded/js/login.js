$(function(){
	$("#user_name").blur(function(){
		var username=document.getElementById("user_name").value;
		$.ajax({
			type:'post',
			url:'../validateUser',
			contentType:'application/x-www-form-urlencoded;charset=utf-8',
			data:'username='+username,
			success:function(responseText){
				$("#d1").html(responseText);
			}
			
		});
		
	});
	
	
});