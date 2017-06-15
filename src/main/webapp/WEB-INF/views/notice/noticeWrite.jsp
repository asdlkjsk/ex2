<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<form id="frm" action="notice${path}" method="post" >
		<p><input type="hidden" name="num" value="${dto.num}"> </p>
		<p><input type="text" name="writer" value="${dto.writer}"> </p>
		<p><input type="text" name="title" value="${dto.title}"> </p>
		<p><input type="text" name="contents" value="${dto.contents}"> </p>
		<p><input type="submit" name="WRITE"> </p>	</form>
	
</body>
</html>