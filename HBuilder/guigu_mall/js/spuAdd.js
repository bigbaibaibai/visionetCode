$(function() {
	//取出分类1id-分类2id-品牌id信息
	var spu_fl1id_fl2id_ppid = localStorage.getItem("spu_fl1id_fl2id_ppid");
	if(spu_fl1id_fl2id_ppid != undefined) {
		//把分类1id，分类2id，品牌id传递到页面表单
		var form_session = JSON.parse(spu_fl1id_fl2id_ppid);
		$.each(form_session, function(i, d) {
			$("#form_spu_add").append("<input type='hidden' name='" + d.name + "' value='" + d.value + "' />");
		});
		localStorage.removeItem("spu_fl1id_fl2id_ppid");
	}
	//当点击添加按钮
	$("input[name=input_submit_add]").click(function(){
		spu_handle.spu_add();
	})
	
	
	//单击添加图片进行预加载显示，并且追加图片按钮
	$("img[picture-img-num=0]").click(function(){
		spu_handle.picture_to_file($(this).attr("picture-img-num"));
	})
	
	$("input[picture-file-num=0]").change(function(){
		spu_handle.picture_input_add(this);
	});
	
	
	
})