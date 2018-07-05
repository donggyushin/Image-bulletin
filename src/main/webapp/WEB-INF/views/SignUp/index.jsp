<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign up</title>
<jsp:include page="../Navigation/style.jsp" flush="false"/>
<link rel="stylesheet" href="./SignUp/styles.css">
</head>
<body>
<jsp:include page="../Navigation/index.jsp" flush="false"/>
<div class="Container">
  <div class="Container__left">
    <img src="./Media/insta.png" alt="instagram_image">
  </div>
  <div class="Container__right">
    <form class="Container__right__SignupForm" action="/user/create" method="post">
      <h2 class="Container__right__SignupForm__h2">Gyu</h2>
      <input class="Container__right__SignupForm__input" required="required" type="text" name="userId" placeholder="Id.." value="">
      <input class="Container__right__SignupForm__input" required="required" type="text" name="userName" placeholder="Name.." value="">
      <input class="Container__right__SignupForm__input" required="required" type="password" name="userPassword" placeholder="password" value="">
      <input class="Container__right__SignupForm__input" required="required" type="email" name="userEmail" placeholder="Email..." value="">
      <input class="Container__right__SignupForm__submit" type="submit" name="" value="submit">
    </form>
  </div>
</div>
</body>
</html>
