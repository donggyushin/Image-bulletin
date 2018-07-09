<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign In</title>
	<jsp:include page="../Navigation/style.jsp" flush="false"/>
  <style media="screen">
    .container {
      width: 100%;
      display: flex;
      justify-content: space-around;
    }

    .container__inner {
      height: 500px;
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      width: 40%;
    }

    .container__inner > span {
      font-family: 'Shrikhand', cursive;
      color: #98999B;
    }

    .container__inner__SigninForm {
      display: flex;
      flex-direction: column;
      width: 100%;
    }

    .container__inner__SigninForm__header {
      font-family: 'Shrikhand', cursive;
      font-size: 40px;
    }

    .container__inner__SigninForm > input {
      width: 80%;
      background-color: #CFD2D1;
      border: 0px;
      height: 30px;
      margin-top: 15px;
      border-radius: 9px;
    }

    .container__inner__SigninForm__button {

      color: white;
      font-size: 25px;
    }

    #container__inner__SigninForm__button {
      background-color: #74B4E8;
    }
  </style>
</head>
<body>
<jsp:include page="../Navigation/index.jsp" flush="false"/>
<div class="container">
  <div class="container__inner">
    <span>Please input your info...</span>
  </div>
  <div class="container__inner">
    <form class="container__inner__SigninForm" action="#" method="post">
      <span class="container__inner__SigninForm__header">Sign In</span>
      <input type="text" name="userId" value="" placeholder="ID...">
      <input type="password" name="userPassword" value="" placeholder="password...">
      <input type="submit" name="submit" id="container__inner__SigninForm__button" class="container__inner__SigninForm__button" value="submit">
    </form>
  </div>
</div>
</body>
</html>
