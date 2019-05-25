$(function() {
	// ----------------------------------------获取精选的图书----------------------------
	var getChoicenessBook = function() {
		var url = "book/getChoicenessBook";
		var args = {};

		$.getJSON(url, args, function(data) {
			
			showChoicenessBook(data);

		});
	}
	
	//------------------------------------------获取特价图书------------------------------
	
	var getSpecialPriceBook = function() {
		var url = "book/getSpecialPriceBook";
		var args = {};

		$.getJSON(url, args, function(data) {
			showSpecialPriceBook(data);
		});
	}
	
	
	//-----------------------------------------精选图书信息在页面显示----------------------
	
	var showChoicenessBook=function(data){
		$(data.values.coicenessBooks).each(function(index,e){
			var $book_div=$(".feat_prod_box:eq(0)").clone(true,true);
			$book_div.find(".prod_img img").attr("src",e.pictureUrl);
			$book_div.find(".box_center .prod_title").text(e.bookName);
			$book_div.find(".box_center .details").text(e.remark);
			$(".feat_prod_box:eq("+index+")").after($book_div);
		});
		$(".feat_prod_box:eq(0)").hide();
	}
	
	//------------------------------------------特价书在页面显示----------------------------
	
	
	var showSpecialPriceBook=function(data){
		$(data.values.coicenessBooks).each(function(index,e){
			var $book_div=$(".new_prod_box:eq(0)").clone(true,true);
			$book_div.find(".thumb").attr("src",e.pictureUrl);
			$book_div.find(".new_book_name").text(e.bookName);
			$(".new_prod_box:eq("+index+")").after($book_div);
		});
		$(".new_prod_box:eq(0)").hide();
	}
	
	
	
	
	
	
	
	//--------------------------------------业务
	//获取精选书
	getChoicenessBook();
	//获取特价书
	getSpecialPriceBook();
	
	
})