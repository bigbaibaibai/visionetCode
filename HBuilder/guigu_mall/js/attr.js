$(function() {
	//展示1级分类
	spu_handle.show_class_1();

	//如果一级分类下拉列表框内容被改变，显示二级分类，和品牌
	$("#select_class_1").change(function() {
		var class_1_id = $("#select_class_1").val();

		//展示二级分类
		spu_handle.show_class_2(class_1_id);

	});
	//发送请求添加商品参数信息
	$("#a_attr_add").click(function() {
		//获取分类2id
		var attr_fl2id = $("#select_class_2").val();
		//转化为json字符串存储到localStorage
		localStorage.setItem("attr_fl2id", attr_fl2id);
	});

})