<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="../Navigation/style.jsp" flush="false"/>
<jsp:include page="./formStyles.jsp" flush="false"/>
</head>
<body>
<jsp:include page="../Navigation/index.jsp" flush="false"/>
<div class="container">
  <div class="formContainer">
    <form class="articleForm" action="/article/upload/${loginedUser.id}" enctype="multipart/form-data" method="post">
      <textarea name="content" rows="8" cols="80" placeholder="you can submit only image files..."></textarea>
      <input type="file" name="files">
      <input class="submit" type="submit" name="submit" value="submit">
    </form>
  </div>
</div>
</body>
</html>
