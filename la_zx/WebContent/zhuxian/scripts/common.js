function getElementsByClassName(className){
	var allEle = document.getElementsByTagName("*");
	var arrNum = 0;
	var eleArr = new Array();
	for(var i=0;i<allEle.length;i++){
		if((allEle[i].getAttribute("class"))==className){
			eleArr[arrNum]=allEle[i];
			arrNum++;
		}
	}
	return eleArr;
}

function addLoadEvent(func){
	var oldonload = window.onload;
	if(typeof window.onload != 'function'){
		window.onload = func;
	}else{
		window.onload = function(){
			oldonload();
			func();
		}
	}
}

function addClass(element,value){
	  if(!element.className){
	    element.className=value;
	  }else{
	    newClassName = element.className;
	    newClassName+=" ";
	    newClassName+=value;
	    element.className = newClassName;
	  }
}

function removeClass(element,value){
	if(!element.className) return false;
	var oldClassName = element.className;
	var classArray = oldClassName.split(" ");
	var newClassName = "";
	for(var i=0;i<classArray.length;i++){
		if(classArray[i]!=value){
			newClassName=newClassName+classArray[i]+" ";
		}
	}
	element.className=newClassName;
}