//自带
$('.message a').click(function() {
	$('form').animate({
		height : "toggle",
		opacity : "toggle"
	}, "slow");
});

$(function() {

	// ----------------------------------------登录验证函数---------------------------------------
	var check_login_form = function(form) {
		var userName = $(form).find("input[name=userName]").val();
		var passWord = $(form).find("input[name=passWord]").val();

		if (userName == "" || passWord == "") {
			alert("用户名或密码不能为空！");
			return false;
		}

		var rex = /^([a-zA-Z0-9_-]{3,16})$/;
		if (!rex.test(userName)) {
			alert("用户名格式不正确！英文或数字3-16位！");
			return false;
		}
		rex = /^[\w_-]{1,16}$/;
		if (!rex.test(passWord)) {
			alert("密码格式不正确！");
			return false;
		}
		return true;
	}

	// -----------------------------------------添加验证函数---------------------------------------
	var check_register_form = function(form) {
		var email = $(form).find("input[name=email]").val();
		if (!check_login_form(form)) {
			return false;
		}

		var rex = /^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/;
		if (!rex.test(email)) {
			alert("邮箱格式不正确！");
			return false;
		}
		return true;
	}

	// ------------------------------------------业务----------------------------------------------
	// ----------------------------------登录
	$("#login_btn").click(function() {
		if (!check_login_form("#login_form")) {
			return false;
		}
		var url = "user/login";
		var args = $("#login_form").serialize();
		$.post(url, args, function(data) {
			alert(data.msg);
			if (data.code == 100) {
				$(location).attr("href","index.html");
			}
		}, "json");
		return false;
	});

	// ----------------------------------注册
	$("#add_btn").click(function() {
		if (!check_register_form("#register_form")) {
			return false;
		}
		var url = "user/addUser";
		var args = $("#register_form").serialize();
		$.post(url, args, function(data) {
			alert(data.msg);
			if (data.code == 100) {
				$(location).attr("href","index.html");
			}
		}, "json");
		return false;
	});

})
