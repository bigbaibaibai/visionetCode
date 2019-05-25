var myHash = window.location.hash.split('#')[1];

document.addEventListener('DOMContentLoaded', function() {

	$.ajax({
		type: 'get',
		url: 'http://localhost:8080/book/getBookForId/' + myHash,
		success: function(data) {
			console.log(data);
			$('._book_out ._book_left').html('<img src="' + data.data.bookTp + '" alt="">')
			$('._book_out ._book_right h3').html(data.data.bookMch);
			$('._book_out ._book_right ._author').html('作者：' + data.data.author);
			$('._book_out ._book_right ._price').html('价格：￥' + (data.data.jg / 100).toFixed(2));
			$('._book_out ._book_in_in p').html(data.data.bookInfoLong);
		}
	});

});


$('._book_out ._book_right ._jiage a').on('click', function() {
	var token = localStorage.token;
	addToCart(myHash, token);
})
