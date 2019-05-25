document.addEventListener('DOMContentLoaded', function() {
	// 左边书籍分类
	$.ajax({
		type: 'get',
		url: 'http://localhost:8080/book/getBookClass',
		success: function(data) {
			console.log(data);
			var htmlStr = '';
			data.data.forEach(function(self, index, arr) {
				htmlStr += '<li><a href="./list.html#' + self.id + '">' + self.flMch + '</a></li>';
			});
			$('.container.text-center .fl_list').html(htmlStr);
		}
	});
	// 右边热销榜
	$.ajax({
		type: 'get',
		url: 'http://localhost:8080/book/getListTop10',
		success: function(data) {
			console.log(data);
			var htmlStr = '';
			data.data.forEach(function(self, index, arr) {
				htmlStr += '<li><a href="./detail.html#' + self.id + '">' + self.bookMch + '</a></li>';
			});
			$('.col-md-2._right ._cxbd').html(htmlStr);
		}
	});
	// 中间下边热门图书
	$.ajax({
		type: 'get',
		url: 'http://localhost:8080/book/getListHot',
		success: function(data) {
			console.log(data);
			var htmlStr = '';
			data.data.forEach(function(self, index, arr) {
				htmlStr += '<div class="col-md-3"><div class="thumbnail _bookinfo"><a href="detail.html#' + self.id +
					'"><img src="' + self.bookTp + '" alt=""></a><div class="caption "><p>' + self.bookMch +
					'</p><p class="_jiage"><a href="javascript:;" class="btn btn-default" role="button" data-bookid="' + self.id +
					'"><span class="glyphicon glyphicon-shopping-cart _caryanse">加入购物车</span></a>￥' + (self.jg / 100).toFixed(2) +
					'</p></div></div></div>'
			});
			$('.row._bottom .row').html(htmlStr);
		}
	});

});

// 点击添加购物车
$('.row._bottom .row').on('click', '.col-md-3 .caption .btn.btn-default', function() {
	var bookID = $(this).attr('data-bookID'),
		token = localStorage.token;
	addToCart(bookID, token);
});
