<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="./styles.css">
<title>Main</title>
	<jsp:include page="./Navigation/style.jsp" flush="false"/>
</head>
<body>
  	<jsp:include page="./Navigation/index.jsp" flush="false"/>
  	<%
  	String ErrorMessage = null;
  	ErrorMessage = (String)request.getAttribute("ErrorMessage");
  	
  	if(ErrorMessage != null){
  		%>
  		<script>alert("Id and email is duplicated");</script>
  		<%
  	}
  	%>
</body>
</html>
