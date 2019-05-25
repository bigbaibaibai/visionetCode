var userID = '',
	bookIds = '',
	addressId = '',
	addressMch = '';


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
					url: 'http://localhost:8080/bookCart/getCart/' + userID,
					success: function(data) {
						console.log(data);
						var htmlStr = '';

						data.data.bookProducts.forEach(function(self, index, arr) {
							htmlStr +=
								'<div class="itemForm"><div class="items checkbox"><input type="checkbox" name="bookIds" data-bookid="' +
								self.id + '"></div><div class="items goods"><div class="img"><a href="javascript:;"><img src="' +
								self.bookTp + '" width="80px" height="80px"></a></div><div class="name"><a href="javascript:;">' +
								self.bookMch + '</a></div></div><div class="items price"><strong>¥' + (self.jg / 100).toFixed(2) +
								'</strong></div><div class="items num"><div class="numBox"><a href="javascript:;" class="left">-</a><input type="text" value="' +
								self.number +
								'"><a href="javascript:;" class="right">+</a></div></div><div class="items sum"><strong>¥' + ((self
									.jg *
									self.number) / 100).toFixed(2) +
								'</strong></div><div class="items opt"><a href="javascript:;">删除</a></div></div>';

						});
						$('.cart .cartCon .cartList').html(htmlStr);
						sInp = $('.cartCon>.cartList>.itemForm>.checkbox>input');
						realNum = $('.cartCon>.cartList>.itemForm').length;
					}
				});

			}
		});

	} else {
		alert('请先登录');
	}

});

// 银行支付，货到付款
$(function() {
	$("#inlineRadio1").click(function() {
		$("#input_bank_info").show();
	});

	$("#inlineRadio2").click(function() {
		$("#input_bank_info").hide();
	});
});

// 点击去结算
$('.cart .cartMoney .toolRight #a_go_pay').on('click', function() {
	console.log($(this));

	var tt = $('.cartCon>.cartList .checkbox input:checked');
	console.log(tt);

	if (tt.length) {

		tt.each(function(index, ele) {
			bookIds += 'bookIds=' + $(ele).attr('data-bookid') + '&';
			console.log(index, $(ele).attr('data-bookid'), bookIds);

		});

		$.ajax({
			type: 'get',
			url: 'http://localhost:8080/user/getAddress/' + userID,
			success: function(data) {
				console.log(data);
				addressId = data.data.id;
				addressMch = data.data.dzMch;
				$('#pay_modal .modal-body #address').val(addressMch);
			}
		});

		$('#goToPayTrigger').trigger('click');


	} else {
		alert('请选择图书');
	}

});

// 点击提交，创建订单
$('#pay_modal .modal-footer .btn.btn-primary').on('click', function() {

	console.log($(this), bookIds, userID, addressId, addressMch);

	$.ajax({
		type: 'post',
		url: 'http://localhost:8080/order/createOrder?' + bookIds + 'addressId=' + addressId + '&addressMch=' +
			addressMch,

		data: {
			userId: userID,
			_method: 'put',
		},
		success: function(data) {
			console.log(data);
			alert(data.message);
			if (data.code == 200) {

			}
		}
	});

});


// 点击删除商品
$('.cartCon>.cartList').on('click', '.opt a', function() {
	var self = $(this),
		inBookId = self.parent().prevAll('.checkbox').children('input').attr('data-bookid');

	$.ajax({
		type: 'post',
		url: 'http://localhost:8080/bookCart/delBook',
		data: {
			userId: userID,
			bookId: inBookId,
			_method: 'delete',
		},
		success: function(data) {
			console.log(data);
			if (data.code == 200) {
				self.parent().parent().remove();
				countSel();
			}
		}
	});

});




// 处理全选按钮
var topAll = $('.cartCon>.cartHead>.checkbox>input'),
	bottomAll = $('.cartMoney>.selectAll>input'),
	sInp,
	realNum,
	selectNum = 0;
// 上边按钮
topAll.on('click', function() {
	selAll(topAll, bottomAll, sInp)
});
// 下边按钮
bottomAll.on('click', function() {
	selAll(bottomAll, topAll, sInp)
});
// 全选函数
function selAll(selA, selB, selS) {
	if (selA.is(':checked')) {
		selB.prop('checked', true);
		for (i = 0; i < selS.length; i++) {
			$(selS[i]).prop('checked', true);
		}
		$('.cartMoney .selSum em').html(realNum);
	} else {
		selB.prop('checked', false);
		for (i = 0; i < selS.length; i++) {
			$(selS[i]).prop('checked', false);
		}
		$('.cartMoney .selSum em').html(selectNum);
	}
	countSel();
}
// 子选择按钮
$('.cartCon>.cartList').on('click', '.checkbox input', function() {
	for (i = 0; i < sInp.length; i++) {
		if ($(sInp[i]).is(':checked')) {
			selectNum += 1;
		}
	}
	countSel();
	if (selectNum == realNum) {
		topAll.prop('checked', true);
		bottomAll.prop('checked', true);
	} else {
		topAll.prop('checked', false);
		bottomAll.prop('checked', false);
	}
	selectNum = 0;
});
// 数量加减按钮
$('.cartCon>.cartList').on('click', '.num .left', function() {
	var numInp = $(this).next();
	var num = numInp.val();
	num <= 1 ? num = 1 : num--;
	numInp.val(num);
	// 单行价格小计
	var price = parseFloat($(this).parent().parent().prev().children().html().slice('1'));
	var total = price * num;
	$(this).parent().parent().next().children().html('￥' + total.toFixed(2));
	countSel();
});
$('.cartCon>.cartList').on('click', '.num .right', function() {
	var numInp = $(this).prev();
	var num = numInp.val();
	num++;
	numInp.val(num);
	// 单行价格小计
	var price = parseFloat($(this).parent().parent().prev().children().html().slice('1'));
	var total = price * num;
	$(this).parent().parent().next().children().html('￥' + total.toFixed(2));
	countSel();
});
// 输入数量判断
$('.cartCon>.cartList .num input').on('input propertychange', function() {
	if (parseInt($(this).val()) <= 1 || parseInt($(this).val()) + '' == 'NaN') {
		$(this).val(1);
	}
	// 单行价格小计
	var price = parseFloat($(this).parent().parent().prev().children().html().slice('1'));
	var total = price * $(this).val();
	$(this).parent().parent().next().children().html('￥' + total.toFixed(2));
	countSel();
});

// 下面的展示已选择多少件商品和总价
function countSel() {
	var oInp = $('.cartCon>.cartList .checkbox input:checked'),
		sumSel = 0,
		sumPrice = 0;
	for (var i = 0; i < oInp.length; i++) {
		sumSel += parseInt($(oInp[i]).parent().nextAll('.num').children().children('input').val());
		sumPrice += parseFloat($(oInp[i]).parent().nextAll('.sum').children().html().slice(1));
	}
	$('.cartMoney .selSum em').html(sumSel);
	$('.cartMoney .priceSum em').html('￥' + sumPrice.toFixed(2));
}
