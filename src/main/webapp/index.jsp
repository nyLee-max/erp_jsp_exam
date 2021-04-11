<%@page import="erp_jsp_exam.ds.JndiDs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<c:set var = "con" value="${JndiDs.getConnection() }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 베이스 연동 테스트</title>
</head>
<body>
	${JndiDs.getConnection() }
</body>
</html>