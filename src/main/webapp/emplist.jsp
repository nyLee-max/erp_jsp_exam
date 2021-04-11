<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href= "css/style.css">
</head>
<body>
	<table class = "tbl_type">
		<thead>
			<tr>
				<td>사원번호</td>
				<td>사원명</td>
				<td>직책</td>
				<td>직속상사</td>
				<td>급여</td>
				<td>부서</td>
				<td>입사일</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="employee" items="${list }">
				<tr>
					<td>${employee.empNo }</td>
					<td>${employee.empName }</td>
					<td>${employee.tno.titleName }</td>
					<td>
					<c:if test="${employee.manager.empNo != 0 }">
					${employee.manager.empName}(${employee.manager.empNo})
					</c:if>
					</td>
					<td><fmt:formatNumber value = "${employee.salary }" pattern="#,###"/></td>
					<td>${employee.dno.deptName}</td>
					<td><fmt:formatDate value = "${employee.hiredate }" pattern="yyyy년 MM월 dd일"/></td>
			</c:forEach>
		</tbody>	
	</table>
</body>
</html>