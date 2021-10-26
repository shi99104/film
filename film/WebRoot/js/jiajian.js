$(function(){
				//初始化
				$('.itxt').val('1');//获取文本框的值
				//加
				$('.increment').click(function(){
					$(this).prev().val(parseInt($(this).prev().val())+1);
					//单击加号时候  当前节点的上一个节点的值   等于   当前节点的上一个节点的值+1
					//$(this) 当前对象
					//prev() 上一个节点
					//parseInt 把文本框中的值 转换为整型（int）  如何不转换的话 获取到的可能是字符串（string)
					//如果获取到的是字符串  ，那么 文不框中的值会是  字符串+1   
				});
 
			
 
				//减
				$('.decrement').click(function(){
					$(this).next().val(parseInt($(this).next().val())-1);
					//和上面一样的 
					if( $('.itxt').val() <= 1 ){
						$('.itxt').val('1');//文本框中的值不能小于1  否则就等于1
					}
					
				});
				
			
			})