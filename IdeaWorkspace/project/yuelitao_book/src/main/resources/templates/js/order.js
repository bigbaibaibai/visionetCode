var userID = '';

document.addEventListener('DOMContentLoaded', function() {

	if (window.localStorage.token) {

		$.ajax({
			async: 'false',
			type: 'post',
			url: 'http://localhost:8080/user/getUserForToken?token=' + window.localStorage.token,
			success: function(data) {
				console.log(data);
				userID = data.data.id;

				$.ajax({
					type: 'get',
					url: 'http://localhost:8080/order/getOrderInfo/' + userID + '?pageNo=1',
					data: '',
					success: function(data) {
						console.log(data);
						var wrapHtml = '',
							innerHtml = '',
							totalMoney = 0;
						data.data.list.forEach(function(self, index, arr) {

							wrapHtml += '<div class="_order_one"><div class="_order_header"><span class="_orderId">订单号：' + self.id +
								'</span><span class="_time">时间：' + (self.chjshj).slice(0, 10) +
								'</span></div>';



							self.item.forEach(function(self, index, arr) {
								console.log(self);
								totalMoney += parseFloat(((self.shpJg * self.shpShl) / 100).toFixed(2));
								wrapHtml += '<div class="_box_item"><div class="_left"><img src="' + self.shpTp +
									'" alt=""></div><div class="_right"><span class="_shop_name">商品名：' + self.shpMch +
									'</span><span class="_shop_num">数量：' + self.shpShl + '</span><span class="_shop_price">价格：￥' + (
										self.shpJg / 100).toFixed(2) + '</span></div></div>';

							});
							wrapHtml += '<div class="_count"><b class="_shop_all">总计：' + totalMoney.toFixed(2) + '￥</b></div></div>';
							totalMoney = 0;

						});
						$('._order ._center ._box').html(wrapHtml);
					}
				});

			}
		});

	} else {
		alert('请先登录');
	}

});
