<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:directive.include file="/WEB-INF/views/layout/include.jsp"/>

<!DOCTYPE html> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Tuan</title>
	<meta name="viewport" content="width=1024" />
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta content="width=device-width, minimum-scale=1, maximum-scale=1" name="viewport" />
	<jsp:directive.include file="/WEB-INF/views/layout/main-script.jsp"/>	
</head>
<body>

	<div class="Outer">
			<tiles:insertAttribute name="mainHeader" />
	    <div id="container">
    		<tiles:insertAttribute name="mainBody" />
	    </div>
	    <div class="Overlay Hide"></div>
	</div>
</body>
</html>
