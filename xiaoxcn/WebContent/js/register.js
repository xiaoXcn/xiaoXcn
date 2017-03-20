window.onload=function(){
	
	var accountEle = document.getElementById("account");
	accountEle.onblur = accountValidate;
	
	var passwordEle = document.getElementById("password");
	passwordEle.onblur = passwordValidate;
	
	var passwordRepEle = document.getElementById("passwordRep");
	passwordRepEle.onblur = passwordRepValidate;
	
	var nameEle = document.getElementById("name");
	nameEle.onblur = nameValidate;
	
	var submitBtnEle = document.getElementById;
	submitBtnEle.onclick=function(){
		return accountValidate()&&passwordValidate()&&passwordRepValidate()&&nameValidate();
	}
		
	
	
}
//帐号校验
function accountValidate(){
	var accountEle = document.getElementById("account");
	var accountMsgEle = document.getElementById("accountMsg");
	if(!isNotBlank(accountEle.value)){
		accountMsgEle.innerHTML="<font color='red'>帐号不能为空!</font>";
		return false;
	}else{
		accountMsgEle.innerHTML="";
		return true;
	}
}
//密码校验
function passwordValidate(){
	var passwordEle = document.getElementById("password");
	var passwordMsgEle = document.getElementById("passwordMsg");
	if(!isNotBlank(passwordEle.value)){
		passwordMsgEle.innerHTML="<font color='red'>密码不能为空!</font>";
		return false;
	}else{
		passwordMsgEle.innerHTML="";
		return true;
	}
}

//确认密码校验
function passwordRepValidate(){
	var passwordRepEle = document.getElementById("passwordRep");
	var passwordRepMsgEle = document.getElementById("passwordRepMsg");
	var passwordEle = document.getElementById("password");
	if(!isNotBlank(passwordRepEle.value)){
		passwordRepMsgEle.innerHTML="<font color='red'>请输入确认密码!</font>";
		return false;
	}else{
		if(passwordRepEle.value != passwordEle.value){
			passwordRepMsgEle.innerHTML="<font color='red'>两次输入的密码不一致!</font>";
			return false;
		}else{
			passwordRepMsgEle.innerHTML="";
			return true;
		}
	}
}

//姓名校验
function nameValidate(){
	var nameEle = document.getElementById("name");
	var nameMsgEle = document.getElementById("nameMsg");
	if(!isNotBlank(nameEle.value)){
		nameMsgEle.innerHTML="<font color='red'>姓名不能为空!</font>";
		return false;
	}else{
		nameMsgEle.innerHTML="";
		return true;
	}
}