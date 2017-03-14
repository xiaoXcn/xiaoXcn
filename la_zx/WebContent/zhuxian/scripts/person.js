function preparePersonIntroduce(){
	if(!document.getElementById) return false;
	var personContent = document.getElementById("person-content");
	var aEle = personContent.getElementsByTagName("a");
	if(aEle.length<=0) return false;
	for(var i=0;i<aEle.length;i++){
		aEle[i].onclick=function(){
			return personIntroduce(aEle,this);
		}
	}
}

function personIntroduce(aEle,ele){
	var textContent = document.getElementsByClassName("text-content");
	for(var j=0;j<textContent.length;j++){
		removeClass(textContent[j],"displayBlock");
		if(aEle[j]==ele){
			addClass(textContent[j],"displayBlock");
		}
	}
	return false;
}

addLoadEvent(preparePersonIntroduce);