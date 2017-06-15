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
	<h1>Notice View</h1>
	<table>
		<tr>
			<td>num</td>
			<td>title</td>
			<td>writer</td>
			<td>date</td>
			<td>hit</td>
		</tr>
		<tr>
			<td>${dto.num }</td>
			<td>${dto.title }</td>
			<td>${dto.writer }</td>
			<td>${dto.reg_date }</td>
			<td>${dto.hit }</td>
		</tr>
		<tr>
			<td>contents</td>
		</tr>
		<tr>
			<td>${dto.contents }</td>
		</tr>
	</table>
	<a href="noticeDelete?num=${dto.num}">Delete</a>
	<a href="noticeUpdate?num=${dto.num}">Update</a>
</body>
</html>