$(function(){
	
	$("#regist_btn").click(function(){
		
		$.ajax({
			type:"post",
			url:app.sso_url+"",
			async:true
		});
		
		return false;
	});
	
})
