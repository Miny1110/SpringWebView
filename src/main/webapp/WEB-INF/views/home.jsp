<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>

<br/><br/><br/>

<div style="padding-left: 20px;">
	<h2>Spring MVC Custom View</h2>
	
	<!-- Simple Custom View 를 통해서 jsp파일로 가지말고 class파일로 가는 것이 가능하다.
	클래스로 화면을 보여줄 수 있다. 클래스에서 처리작업을 하고 클래스에서 뷰를 만들 수 있다.
	이렇게 클래스로 만드는 뷰가 PDF와 Excel같은 것들 -->
	<!-- href 주소 "" 맨 앞에는 / 있으면 안된다. 주의! -->
	<h3>1. <a href="simpleCustomView.action">Simple Custom View</a></h3>
	
	<h3>2. <a href="pdfView.action">PDF View</a></h3>
	
	<h3>3. <a href="excelView.action">Excel View</a></h3>
	
	<h3>4. File Upload</h3>
	<form action="upload.action" method="post" enctype="multipart/form-data">
		<input type="file" name="upload"/><br/>
		<input type="submit" value="전송"/><br/>
	</form>
	
	<h3>5. <a href="download.action">File Download</a></h3>
</div>


</body>
</html>
