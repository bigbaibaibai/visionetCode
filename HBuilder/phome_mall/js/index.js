document.addEventListener('DOMContentLoaded', function() {
	$.ajax({
		type: 'get',
		url: 'http://localhost:8081/cat/getLeft?size=9',
		success: function(data) {
			var str = '';
			console.log(data);
			data.data.forEach(function(self, index, arr) {
				if(index) {
					str += '<li><a href="javascript:;">' + self.name + '</a></li>';
				} else {
					str += '<li><a href="./liebiao.html" target="_blank">' + self.name + '</a></li>';
				}
			});
			$('.nav.fl ul').html(str);
		},
	});

	
});

$('.banner_y center .nav').on('hover', 'li', function(){
	console.log('hover');
});

