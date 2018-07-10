<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="../Navigation/style.jsp" flush="false"/>
<jsp:include page="./formStyle.jsp" flush="false" />
<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
<!-- include summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.js"></script>
</head>
<body>
<jsp:include page="../Navigation/index.jsp" flush="false"/>
<div class="summernoteContainer">
  <form id="articleForm" role="form" action="/article" method="post">
    <br style="clear: both">
    <h3 style="margin-bottom: 25px;">Article Form</h3>

    <div class="form-group">
      <textarea class="form-control" id="summernote" name="content" placeholder="content" maxlength="140" rows="7"></textarea>
    </div>
    <button type="submit" id="submit" name="submit" class="btn btn-primary pull-right">Submit Form</button>
  </form>
</div>
<div id="imageBoard">
  <ul>
    <c:forEach items="${files}" var="file">
      <li><img src="/image/${file}" width="480" height="auto" alt="뭘 봐"></li>
    </c:forEach>
  </ul>
</div>

<script type="text/javascript">
  $(document).ready(function() {
    $('#summernote').summernote({
      height: 300,
      minHeight: null,
      maxHeight: null,
      focus: true,
      callbacks: {
        onImageUpload: function(files, editor, welEditable) {
          for(var i = files.length - 1; i >= 0; i --) {
            sendFile(files[i], this);
          }
        }
      }
    });
  });


  function sendFile(file, el) {
    var form_data = new FormData();
    form_data.append('file', file);
    $.ajax({
    	data: form_data,
    	type: "POST",
    	url: '/image',
    	cache: false,
    	contentType: false,
    	enctype: 'multipart/form-data',
    	processData: false,
    	success: function(url) {
    		$(el).summernote('editor.insertImage', url);
    		$('#imageBoard > ul').append('<li><img src=" '+url+'" width="480" height="auto"/></li>');
    	}
    });
  }




</script>


</body>
</html>
