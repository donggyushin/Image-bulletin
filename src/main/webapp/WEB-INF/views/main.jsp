<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Main</title>
	<jsp:include page="./Navigation/style.jsp" flush="false"/>
	<jsp:include page="./styles.jsp" flush="false" />

</head>
<body>
  	<jsp:include page="./Navigation/index.jsp" flush="false"/>
  	<%
  	String sessionedUser2 = null;
  	sessionedUser2 = (String)session.getAttribute("sessionedUser");
  		if(sessionedUser2 != null){
  			%>
  			<div>
          <span class="postButton"><a href="/article">Post</a></span>
        </div>
  			<%
  		}
  	%>
  	<%
  	String ErrorMessage = null;
  	ErrorMessage = (String)request.getAttribute("ErrorMessage");

  	if(ErrorMessage != null){
  		%>
  	<div class="modalBox" id="modalBox">
      <div class="modalBox__head">
        <hr>
      </div>
      <div class="modalBox__body">
        <div class="modalBox__body__row">
          <span class="modalBox__body__row__message"><%=ErrorMessage%></span>
        </div>
        <div class="modalBox__body__row">
          <span class="modalBox__body__row__close" onclick="document.getElementById('modalBox').style.display='none'">close</span>
        </div>
      </div>
    </div>
  		<%
  		ErrorMessage = null;
  	}
  	%>

</body>
</html>
