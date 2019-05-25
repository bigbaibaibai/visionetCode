$(function() {

	$("#regist_btn").click(function() {
		var password1 = $($("input[name=password]")[0]).val();
		var password2 = $($("input[name=password]")[1]).val();
		alert("");
		if(password1 != password2) {
			alert(两次密码输出不一致);
			return false;
		}
		alert("");   
		$.ajax({
			type: "post",
			url: app.sso_url + "regist",
			data: {
				username: $("input[name=username]").val(),
				password: password1,
				phone: $("input[name=phone]").val(),
			}
		});

		return false;
	});

})