<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign In</title>
	<jsp:include page="../Navigation/style.jsp" flush="false"/>
  	<jsp:include page="./styles.jsp" flush="false"/>
</head>
<body>
<jsp:include page="../Navigation/index.jsp" flush="false"/>
<div class="container">
  <div class="container__inner">
    <span>Please input your info...</span>
  </div>
  <div class="container__inner">
    <form class="container__inner__SigninForm" action="/user/login" method="post">
      <span class="container__inner__SigninForm__header">Sign In</span>
      <input type="text" name="userId" value="" placeholder="ID..." required="required">
      <input type="password" name="userPassword" value="" placeholder="password..." required="required">
      <input type="submit" name="submit" id="container__inner__SigninForm__button" class="container__inner__SigninForm__button" value="submit">
    </form>
  </div>
</div>
</body>
</html>
