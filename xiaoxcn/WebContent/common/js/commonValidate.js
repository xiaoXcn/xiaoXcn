//非空验证
function isNotBlank(obj){
	if (typeof(obj) == "undefined") {
		return false;
	}
	if (obj == null) {
		return false;
	}
	if (obj == '') {
		return false;
	}
	if (obj.replace(/(^\s*)|(\s*$)/g, "").length == 0){
		return false;
	}
	return true;
}
//验证手机格式
function isPhoneNumber(obj){
	var phoneReg = /^0?1[3|4|5|7|8][0-9]\d{8}$/;
	return phoneReg.test(obj);
}
//验证邮箱格式
function isEmail(obj){
	var emailReg =  /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	return emailReg.test(obj);
}
//验证身份证格式  *只能校验格式，无法校验真假
function isIdCardNo(obj){
	var idCardNoReg = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/; 
	return idCardNoReg.test(obj);
}
//验证出生日期格式 格式为 yyyy-MM-dd
function dateFormat(obj){
	var dateFormatReg = /((^((1[8-9]\d{2})|([2-9]\d{3}))(-)(10|12|0?[13578])(-)(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(11|0?[469])(-)(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(0?2)(-)(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)(-)(0?2)(-)(29)$)|(^([3579][26]00)(-)(0?2)(-)(29)$)|(^([1][89][0][48])(-)(0?2)(-)(29)$)|(^([2-9][0-9][0][48])(-)(0?2)(-)(29)$)|(^([1][89][2468][048])(-)(0?2)(-)(29)$)|(^([2-9][0-9][2468][048])(-)(0?2)(-)(29)$)|(^([1][89][13579][26])(-)(0?2)(-)(29)$)|(^([2-9][0-9][13579][26])(-)(0?2)(-)(29)$))/;
	return dateFormatReg.test(obj);
}