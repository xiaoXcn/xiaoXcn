window.onload=function(){
	
	var submitBtnEle = document.getElementById("submitBtnEle");
	submitBtnEle.onClick=function(){
		return accountValidate()&&passwordValidate();
	}
		
	
	
}
//帐号校验
function accountValidate(){
	var accountEle = document.getElementById("account");
	var tipMsgEle = document.getElemnetById("tipMsg");
	if(isBlank(accountEle.value)){
		tipMsgEle.innerHTML="<font color='red'>请输入帐号!</font>";
		return false;
	}else{
		tipMsgEle.innerHTML="";
		return true;
	}
}
//密码校验
function passwordValidate(){
	var passwordEle = document.getElementById("password");
	var tipMsgEle = document.getElemnetById("tipMsg");
	if(isBlank(passwordEle.value)){
		tipMsgEle.innerHTML="<font color='red'>请输入密码!</font>";
		return false;
	}else{
		tipMsgEle.innerHTML="";
		return true;
	}
}
