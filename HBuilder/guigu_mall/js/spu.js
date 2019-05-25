$(function() {
	//展示1级分类
	spu_handle.show_class_1();

	//如果一级分类下拉列表框内容被改变，显示二级分类，和品牌
	$("#select_class_1").change(function() {
		var class_1_id = $("#select_class_1").val();

		//展示二级分类
		spu_handle.show_class_2(class_1_id);

		//展示品牌
		spu_handle.show_pp(class_1_id);
	});

	$("#a_spu_add").click(function() {
		//序列化成数组
		var form = $("#form_spu_add").serializeArray();
		//转化为json字符串存储到localStorage
		localStorage.setItem("spu_fl1id_fl2id_ppid", JSON.stringify($("#form_spu_add").serializeArray()));
	});

})