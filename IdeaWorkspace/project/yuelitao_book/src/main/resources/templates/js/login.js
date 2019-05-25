//自带，注册登录切换
$('.message a').click(function() {
	$('._modal_form').animate({
		height: "toggle",
		opacity: "toggle"
	}, "slow");
});

document.addEventListener('DOMContentLoaded', function() {

	if (window.localStorage.token) {
		$('#bs-example-navbar-collapse-1 ul .login').hide();
		$('#bs-example-navbar-collapse-1 ul .exit').show();
		$('#bs-example-navbar-collapse-1 ul .personInfo').show();
	}

});


// 点击顶部搜索
$('#bs-example-navbar-collapse-1 .navbar-form button[type="submit"]').on('click', function(e) {
	e.preventDefault();

	var searchKey = $('#bs-example-navbar-collapse-1 .navbar-form .form-group input').val();

	if (searchKey) {
		window.localStorage.searchKey = searchKey;
		var href = window.location.href;
		var sp = href.split('/');
		sp[sp.length - 1] = 'list.html';
		var fin = sp.join('/');
		window.open(fin);
		console.log(fin);
	}


});




// 点击退出
$('#bs-example-navbar-collapse-1 ul .exit').on('click', function() {
	var self = $(this);

	$.ajax({
		type: 'post',
		url: 'http://localhost:8080/user/logout?token=' + window.localStorage.token,
		success: function(data) {
			console.log(data);
			alert(data.message);

			if (data.code == 200) {
				window.localStorage.clear();
				self.hide();
				$('#bs-example-navbar-collapse-1 ul .personInfo').hide();
				$('#bs-example-navbar-collapse-1 ul .login').show();
			}

		}
	});

});



$(function() {
	// ---------------------------------------登录验证函数---------------------------------------
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


	// 业务
	// 登录
	$("#login_btn").click(function(e) {

		e.preventDefault();

		if (!check_login_form("#login_form")) {
			return false;
		}

		var userName = $('#login_form input[name="userName"]').val(),
			passWord = $('#login_form input[name="passWord"]').val();

		console.log('login', userName, passWord);

		$.ajax({
			type: 'post',
			url: 'http://localhost:8080/user/login?username=' + userName + '&password=' + passWord,
			success: function(data) {
				console.log(data);
				alert(data.message);

				if (data.code == 200) {
					$('#my_model .form .close._close')[0].click();
					window.localStorage.setItem('token', data.data);
					$('#bs-example-navbar-collapse-1 ul .login').hide();
					$('#bs-example-navbar-collapse-1 ul .exit').show();
					$('#bs-example-navbar-collapse-1 ul .personInfo').show();
				}

			}
		});

	});

	// 注册
	$("#add_btn").click(function(e) {

		e.preventDefault();

		if (!check_register_form("#register_form")) {
			return false;
		}

		var userName = $('#register_form input[name="userName"]').val(),
			passWord = $('#register_form input[name="passWord"]').val(),
			email = $('#register_form input[name="email"]').val();

		console.log('register', userName, passWord, email);

		$.ajax({
			type: 'post',
			url: 'http://localhost:8080/user/regist?yhMch=' + userName + '&yhMm=' + passWord + '&yhYx=' + email,
			success: function(data) {
				console.log(data);
				alert(data.message);
				data.code == 200 ? $('.message a')[0].click() : '';
			}
		});


	});

});


function addToCart(bookID, token) {
	var userID = '';

	if (token) {

		$.ajax({
			async: 'false',
			type: 'post',
			url: 'http://localhost:8080/user/getUserForToken?token=' + token,
			success: function(data) {
				console.log(data);
				userID = data.data.id;

				$.ajax({
					async: 'false',
					type: 'post',
					url: 'http://localhost:8080/bookCart/addBookOne',
					data: {
						userId: userID,
						bookId: bookID,
						_method: 'put',
					},
					success: function(data) {
						console.log(data);
						data.code == 200 ? alert('添加成功') : '';
					}
				});

			}
		});

	} else {
		alert('请先登录');
	}
}
