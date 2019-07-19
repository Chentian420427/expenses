
$.each($("#menu a"),function(i,item){
	
	var parentMenu = item.parentNode.parentNode.parentNode.children[0];
	
	var url = location.href;
	console.log("当前页面:"+url)
	if(url.indexOf(item.href) != -1){
		console.log(parentMenu);
		parentMenu.setAttribute("class",parentMenu.getAttribute("class")+" parentactive");
		item.setAttribute("class","menuactive");
		
	}else{
		item.parentNode.removeAttribute("menuactive");
		parentMenu.removeAttribute(" parentactive");
	}
	
	
});