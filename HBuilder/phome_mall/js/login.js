$(function() {

	$("#submit_login").click(function() {

		var username = $("input[name=username]").val();
		var password = $("input[name=password]").val();
		var args = {
			'username': username,
			'password': password
		}
		alert(args);
		var url = app.sso_url + "login";
		$.ajax({
			type: "post",
			url: url,
			data: args,
			success: function(data) {
				if(data.code != 200) {
					alert(data.message);
				}
				window.location.href = "index.html";
			}
		});

		return false;
	});
	

})