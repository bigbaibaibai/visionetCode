


//////////////////////////////////////准备阶段结束////////////////////////////////
	var getCssIndex=function(node,css){
		for(var i=0;i<css.length;i++){
	    	if(node==css[i].selectorText)
	    	{
	    	    return i;
	    	}
		}
		return 0;
	};	                    //传入样式列表集合，查找选定标识符返回下标
		var getStr=function(numbered){
		return '.carousel li:nth-child('+numbered+')';     //用的太多懒得打写个临时函数
	}
var Interval=function(getting,css){               //动态设置播放图片
		var index=getting.indexofTure();
		if(getting.length==index+1)
		{
			var j=1;
		}
		else{
			var j=index+2;
		}
		if(j>1)
		{	
			css[getCssIndex(getStr(j-1),css)].style.display='none';
		}
		else
		{
			css[getCssIndex(getStr(getting.length),css)].style.display='none';
		}
		css[getCssIndex(getStr(j),css)].style.display='block';
		getting[index]='false';
		getting[j-1]='ture';
		//alert('获取第'+j+css[getCssIndex(getStr(j),css)].cssText);
		//alert(getting);
	}





//////////////////////////////////////////获取对象和集合阶段////////////////////////////////
var toCarousel=function(classn){
	var allUl=document.getElementsByTagName('ul');
	for(var i in allUl)
	{
		if(allUl[i].className==classn)
		{
			var ul=allUl[i];      //获取class为carousel的ul
		}
	} 
	if(ul==undefined)
	{
		return;
	}
	
	if(document.getElementsByTagName('style').length==0)
	{
		var head=document.getElementsByTagName('head')[0];
		var style=document.createElement('style'); 
		head.appendChild(style);          //如果HTML文件中head内没有style则添加style标签
	}	
	var sheet=document.getElementsByTagName('style')[0].sheet;   //获取style样式表对象
	var css=sheet.cssRules;    //获取样式表内属性的集合
    var li=ul.children;




	/////////////////////////////////////设置属性阶段///////////////////////////////////////////
	sheet.insertRule('@keyframes myani{0%{opacity:0.7;}20%{opacity:1;}}',0);
	sheet.insertRule('.carousel li{animation-name: myani;animation-duration: 2s;',0);


	(function(){
		for(var num=2;num<=ul.children.length;num++)
		{
			sheet.insertRule(getStr(num)+'{display:none;}',num-1);
		}
	})();
	

	sheet.insertRule('.carousel li:nth-child('+1+'){display:block;}',0);






////////////////////////////////////////设置正在播放的图片的标识符/////////////////////////////////
	var getting=new Array(ul.children.length);

	getting.indexofTure = function() {
	        var a = this;                //增加方法
	        for (var i = 0; i < a.length; i++) {
	            if (a[i] == 'ture')
	                return i;
	        }
	    };
	(function(){
		for(var i=0;i<getting.length;i++)
		{
			getting[i]='false';
		}
	})();  
	getting[0]='ture';
	


//////// 设置定时器开启轮播图
	var IntervalIndex=setInterval(function(){
		Interval(getting,css);
	} ,2000);             				




//////////////////////////////////////////butten按钮事件设置/////////////////////////////////////
	(function(){
		
		var allUl=document.getElementsByTagName('ul');
		var ul1;
		var ul2;
		for(var i in allUl)
		{
			if(allUl[i].className=='butten_direction')
			{
				ul1=allUl[i];      //获取class为butten的ul
			}
			if(allUl[i].className=='butten_point')
			{
				ul2=allUl[i];      //获取class为butten的ul
			}
		} 
		if(ul1!=undefined)
		{
			var li=ul1.children;
			li[0].addEventListener('click',function(){
				var index=getting.indexofTure();
				if(1==index+1)
				{
					var j=getting.length;
				}
				else{
					var j=index;
				}
				if(j==getting.length)
				{	
					css[getCssIndex(getStr(1),css)].style.display='none';
				}
				else
				{
					css[getCssIndex(getStr(j+1),css)].style.display='none';
				}	
				css[getCssIndex(getStr(j),css)].style.display='block';
				getting[index]='false';
				getting[j-1]='ture';
	
				clearInterval(IntervalIndex);
				IntervalIndex=setInterval(function(){
					Interval(getting,css);                    //重置定时器
				} ,2000);
			},false); 
			li[1].addEventListener('click',function(){
				var index=getting.indexofTure();
				if(getting.length==index+1)
				{
					var j=1;
				}
				else{
					var j=index+2;
				}
				if(j>1)
				{	
					css[getCssIndex(getStr(j-1),css)].style.display='none';
					
				}
				else
				{
					css[getCssIndex(getStr(getting.length),css)].style.display='none';
				}
				css[getCssIndex(getStr(j),css)].style.display='block';
				getting[index]='false';
				getting[j-1]='ture';
	
				clearInterval(IntervalIndex);
				IntervalIndex=setInterval(function(){
					Interval(getting,css);                    //重置定时器
				} ,2000);
			},false); 
		}
		if(ul2!=undefined){
			///////////////////////////为每一个按钮添加单击函数
			var li=ul2.children;
			for(var i=0;i<li.length;i++)
			{
				li[i].index=i;
			}                      ///////////为下端按钮对象添加私有属性index记录对象自身的下标
			for(var i=0;i<li.length;i++)
			{
				li[i].addEventListener('click',function(){
					var a=this.index;
					var index=getting.indexofTure();
				 	css[getCssIndex(getStr(index+1),css)].style.display='none';
					css[getCssIndex(getStr(a+1),css)].style.display='block';
					getting[index]='false';
					getting[a]='ture';
					clearInterval(IntervalIndex);
					IntervalIndex=setInterval(function(){
					Interval(getting,css);                    //重置定时器
					} ,2000);
				},false);
			}
		}

	})();
}


 toCarousel('carousel');







