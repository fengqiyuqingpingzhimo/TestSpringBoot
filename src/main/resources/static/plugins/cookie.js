// Wangdm 2018-1-2 09:33:09
"use strict";

//设置 cookie 值的函数 当exdays为0时删除cookie
function setCookie(cname,cvalue,exdays){
  var d = new Date();
  d.setTime(d.getTime()+(exdays*24*60*60*1000));
  var expires = "expires="+d.toGMTString();
  document.cookie = cname + "=" + cvalue + "; " + expires+"; path=/";
}
//获取 cookie 值的函数
function getCookie(cname){
  var name = cname + "=";
  var ca = document.cookie.split(';');
  for(var i=0; i<ca.length; i++){
    var c = ca[i].trim();
    if (c.indexOf(name)==0) return c.substring(name.length,c.length);
  }
  return "";
}
//获取该浏览器下能检测到的全部cookie 
function getCookies(){
	var cos = document.cookie.split(';'),
	    re=[];
	for(var i=0; i<cos.length; i++){
		var arrcos= new Object();
		var _coo=cos[i].trim();
		if(_coo.indexOf('"')<0){//如果不包含" 最后一个= 即分隔符
			arrcos.name=_coo.substring(0,_coo.lastIndexOf('='));
			arrcos.value=_coo.substring(_coo.lastIndexOf('=')+1,_coo.length);
		}else{//如果包含" 说明cookie值比较复杂 第一个出现的" 与最后一个出现的"中间 即为 cookie值
			arrcos.name=_coo.substring(0,_coo.indexOf('"')-1);
			arrcos.value=_coo.substring(_coo.indexOf('"')+1,_coo.lastIndexOf('"'));
		}
		re.push(arrcos);
	}
	return re;
}
