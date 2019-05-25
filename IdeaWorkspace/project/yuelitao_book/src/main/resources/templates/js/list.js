var myHash = window.location.hash.split('#')[1],
	pageNum,
	cateArr = ['', '文学类', '艺术类', '网络文学', '童话', '科学类', '青春励志类', '教育', '人文类'];


document.addEventListener('DOMContentLoaded', function() {
	pageNum = $('.pagination li.active a').text();

	pageAjax();

});


$('.pagination').on('click', 'li.pageNum', function() {
	var self = $(this);
	self.addClass('active').siblings().removeClass('active');
	pageNum = self.children('a').text();
	pageAjax();
});


$('.text-center._beijing .container').on('click', '.thumbnail._bookinfo .caption .btn.btn-default', function() {
	var bookID = $(this).attr('data-bookID'),
		token = localStorage.token;
	addToCart(bookID, token);
});








function queryAjax() {
	$.ajax({
		async: 'false',
		type: 'get',
		url: 'http://localhost:8080/book/getListForClass?pageNo=' + pageNum + '&query=' + myHash,
		success: function(data) {
			console.log(data);
		},
	});
}



function pageAjax() {
	var url = '';
	if (window.localStorage.searchKey) {
		url = 'http://localhost:8080/book/getListForClass?pageNo=' + pageNum + '&query=' + window.localStorage.searchKey;
		$('._beijing .kehuan').hide();
	} else {
		url = 'http://localhost:8080/book/getListForClass?pageNo=' + pageNum + '&bookClassId=' + myHash;
		$('._beijing .kehuan').html(cateArr[myHash]);
	}

	$.ajax({
		async: 'false',
		type: 'get',
		url: url,
		success: function(data) {
			console.log(data);
			var totalPageNum = data.data.navigatepageNums.length;

			// 中间内容
			var htmlStr = '';
			data.data.list.forEach(function(self, index, arr) {

				htmlStr += '<div class="col-md-3"><div class="thumbnail _bookinfo"><img src="' + self.bookTp +
					'"><div class="caption"><p>' + self.bookMch +
					'</p><p class="_jiage"><a href="javascript:;" class="btn btn-default" role="button" data-bookid="' + self.id +
					'"><span class="glyphicon glyphicon-shopping-cart _caryanse">加入购物车</span></a>￥' +
					(self.jg / 100).toFixed(2) + '</p></div></div></div>';
			});
			$('.text-center._beijing .container').html(htmlStr);

			// 下面的页码
			var pageNumStr =
				'<li><a href="javascript:;" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>';
			for (var i = 1; i <= totalPageNum; i++) {
				if (i == data.data.pageNum) {
					pageNumStr += '<li class="pageNum active"><a href="javascript:;">' + i + '</a></li>';
				} else {
					pageNumStr += '<li class="pageNum"><a href="javascript:;">' + i + '</a></li>';
				}
			}
			pageNumStr += '<li><a href="javascript:;" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>';
			$('.pagination').html(pageNumStr);


			window.localStorage.removeItem('searchKey');
		}
	});

}
