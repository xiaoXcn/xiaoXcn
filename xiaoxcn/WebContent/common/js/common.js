

function getXMLHttpRequest(){
	XMLHttpRequest xmlHttpRequest = null;
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlHttpRequest=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
		xmlHttpRequest=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	return xmlHttpRequest;
}