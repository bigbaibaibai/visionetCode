var username = $('._input form #disabledInput'),
	nickname = $('._input form #nickname'),
	phone = $('._input form #phone'),
	email = $('._input form #email'),
	address = $('._input form #address'),
	userID;

document.addEventListener('DOMContentLoaded', function() {

	if (window.localStorage.token) {

		$.ajax({
			type: 'post',
			url: 'http://localhost:8080/user/getUserForToken?token=' + window.localStorage.token,
			success: function(data) {
				console.log(data);
				username.val(data.data.yhMch);
				nickname.val(data.data.yhNch);
				phone.val(data.data.yhShjh);
				email.val(data.data.yhYx);
				userID = data.data.id;
			}
		});

	} else {
		alert('请先登录');
	}

});


// 点击保存按钮
$('._input form button').on('click', function(e) {
	e.preventDefault();


	$.ajax({
		type: 'post',
		url: 'http://localhost:8080/user/updateUser',
		data: {
			id: userID,
			yhMch: username.val(),
			yhNch: nickname.val(),
			yhShjh: phone.val(),
			yhYx: email.val(),
			address: address.val(),

		},
		success: function(data) {
			console.log(data);
			data.code == 200 ? alert(data.message) : '';
		}
	});

});
