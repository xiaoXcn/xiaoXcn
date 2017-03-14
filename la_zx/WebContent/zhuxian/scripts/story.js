function prepareShowText(){
	if(!document.getElementById) return false;
	if(!document.getElementById("story-content")) return false;
	var storyContent = document.getElementById("story-content");
	var aEles = storyContent.getElementsByTagName("a");
	for(var i=0;i<aEles.length;i++){
		aEles[i].onclick=function(){
			return showText(this);
		}
	}
}

function showText(ele){
	var storyContent = document.getElementById("story-content");
	var pEles = storyContent.getElementsByTagName("p");
	for(var i=0;i<pEles.length;i++){
		removeClass(pEles[i],"displayBlock");
	}
	var liEle=ele.parentNode.nextSibling;
	while(liEle.nodeType!=1){
		liEle=liEle.nextSibling;
	}
	var pEles = liEle.getElementsByTagName("p");
	for(var i=0;i<pEles.length;i++){
		addClass(pEles[i],"displayBlock");
		console.log("showText:"+pEles[i].nodeName+"    "+pEles[i].className)
	}
	return false;
}
addLoadEvent(prepareShowText);