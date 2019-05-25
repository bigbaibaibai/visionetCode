var spu_handle = {
	//显示分类1到下拉菜单中
	show_class_1: function() {
		var url = "js/json/class_1.js";
		//获取静态文件中的json对象
		$.getJSON(url, function(e) {
			//遍历json对象
			$.each(e, function(index, data) {
				//添加到下拉菜单中
				$("#select_class_1").append("<option value='" + data.id + "'>" + data.flmch1 + "</option>");
			});
		});
	},
	//根据分类1的id显示分类2到下拉菜单中
	show_class_2: function(class_1_id) {
		$("#select_class_2").empty();
		var url = "js/json/class_2_" + class_1_id + ".js";
		$.getJSON(url, function(e) {
			$.each(e, function(index, data) {
				$("#select_class_2").append("<option value='" + data.id + "'>" + data.flmch2 + "</option>");
			});
		});
	},
	//展示品牌
	show_pp: function(class_1_id) {
		$("#select_pp").empty();
		var url = "js/json/tm_class_1_" + class_1_id + ".js";
		$.getJSON(url, function(e) {
			$.each(e, function(index, data) {
				$("#select_pp").append("<option value='" + data.id + "'>" + data.ppmch + "</option>");
			});
		});
	},
	//添加spu信息
	spu_add: function() {

		var url = app.basicUrl + "/spu/add.do";

		var form = new FormData(document.getElementById("form_spu_add"));
		console.log($("#form_spu_add").serialize());
		$.ajax({
			url: url,
			type: "post",
			data: form,
			processData: false,
			contentType: false,
			success: function(data) {
				alert("成功");
				console.log(JSON.stringify(data));
			},
			error: function(e) {
				alert("错误！！");
			}
		});

		//		$("#form_spu_add").attr("action", url);
		//		$("#form_spu_add").ajaxSubmit(function(data) {
		//			console.log(JSON.stringify(data));
		//		});

	},
	//图片触发文件上传
	picture_to_file: function(index) {
		$("input[picture-file-num=" + index + "]").click();
	},
	//图片预加载
	picture_input_add: function(input) {

		//获取index
		var index = $(input).attr("picture-file-num");
		//保存相应的img对象
		var $img = $("img[picture-img-num=" + index + "]");
		//保存原有的src
		var oldSrc = $img.attr("src");

		//修改图片的src
		var url = window.URL.createObjectURL(input.files[0]);
		$img.attr("src", url);

		//如果图片被第一次改变，则克隆图片的文件域，并添加
		if($(input).attr("add_flag") == "flag") {

			var $file = $("div[picture-div-num=" + index + "]");

			var $newFile = $file.clone(true);

			$newFile.find("input").attr("picture-file-num", index + 1);
			$newFile.find("img").attr("src", oldSrc).attr("picture-img-num", index + 1);

			$newFile.attr("picture-div-num", index + 1);
			$newFile.insertAfter($file[0]);
			$(input).attr("add_flag", "false");
		}

	}
	//追加添加图片按钮

}