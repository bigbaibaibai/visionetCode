//
$(function() {

	//头部大广告
	$.ajax({
		type: "get",
		url: app.rest_url + "content/getContentList/89",
		success: function(data) {
			$(".banner_y").attr("style", "background: url(" + data.data[0].pic + ") repeat;");
		}
	});

	//中部小广告
	$.ajax({
		type: "get",
		url: app.rest_url + "content/getContentList/90",
		success: function(data) {
			$("#center_adv").find("div").each(function(index, d) {
				$(d).find("img").attr("src", data.data[index].pic);
			});
		}
	});

	//下部小广告
	$.ajax({
		type: "get",
		url: app.rest_url + "content/getContentList/91",
		success: function(data) {
			$("#peijian1").find("img").attr("src", data.data[0].pic);
			$("#peijian6").find("img").attr("src", data.data[1].pic);
		}
	});

	//渲染页面明星单品
	$.ajax({
		type: "get",
		url: app.item_url + "query",
		data: {
			pageSize: 5,
			classId: 1
		},
		success: function(data) {
			$("#mingxing").find(".mingxing").each(function(index, d) {
				var item = data.data.list[index];
				var $d = $(d);
				$d.find(".sub_mingxing img").attr("src", item.image);
				$d.find(".pinpai a").text(item.title);
				$d.find(".youhui").text(item.sellPoint);
				$d.find("jiage").text(item.price + "元");
			});
		}
	});

	$.ajax({
		type: "get",
		url: app.item_url + "query",
		data: {
			pageSize: 9,
			classId: 7
		},
		success: function(data) {
			var $peijian = $("#peijian");
			var $content1 = $peijian.find(".content:eq(0)");
			var $content2 = $peijian.find(".content:eq(1)");
			$(data.data.list).each(function(index, d) {
				if(index < 4) {
					$content1.find(".remen").each(function(i, remen) {
						$(remen).find(".tu img").attr("src", d.image);
						$(remen).find(".miaoshu a").text(d.title);
						$(remen).find(".jiage").text(d.price);
						$(remen).find(".pingjia").text("销量：" + d.barcode);
						$(remen).find(".piao span").text(d.sellPoint);
					});
				} else {
					if(index == 7) {
						$content2.find(".hongmi img").attr("src", d.image);
					}
					if(index == 8) {
						$content2.find(".liulangengduo img").attr("src", d.image);
					}
					$content2.find(".remen").each(function(i, remen) {
						$(remen).find(".tu img").attr("src", d.image);
						$(remen).find(".miaoshu a").text(d.title);
						$(remen).find(".jiage").text(d.price);
						$(remen).find(".pingjia").text("销量：" + d.barcode);
						$(remen).find(".piao span").text(d.sellPoint);
					});
					
				}

			});
		}
	});

})