$(function(){
	var attr_fl2id = localStorage.getItem("attr_fl2id");
	if(attr_fl2id != undefined) {
		//把分类1id，分类2id，品牌id传递到页面表单
		$("#form_attr_add").append("<input type='hidden' name='flbh2' value='" + attr_fl2id + "' />");
		localStorage.removeItem("attr_fl2id");
	}
	
})
