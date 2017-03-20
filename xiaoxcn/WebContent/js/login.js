window.onload=function(){
	
	var submitBtnEle = document.getElementById("submitBtn");
	submitBtnEle.onclick=function(){
		if(accountValidate()&&passwordValidate()){
			var loginFormEle = document.getElementById("loginForm");
			loginFormEle.submit();
		}
	}
		
	
	
}
//帐号校验
function accountValidate(){
	var accountEle = document.getElementById("account");
	var tipMsgEle = document.getElementById("tipMsg");
	if(!isNotBlank(accountEle.value)){
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
	var tipMsgEle = document.getElementById("tipMsg");
	if(!isNotBlank(passwordEle.value)){
		tipMsgEle.innerHTML="<font color='red'>请输入密码!</font>";
		return false;
	}else{
		tipMsgEle.innerHTML="";
		return true;
	}
}
