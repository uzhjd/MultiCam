<%@ page contentType="text/html; charset=UTF-8"
		 import="chap11.*"
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C" %>

<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>JSTL: if</title>
</head>

<body>

	<h2>JSTL: if</h2>
	<hr />
	
	<c:catch var="msg" value="user1" />
	msg: ${msg}
	<hr />
	
	<C:if test="${msg == 'user1'}" var="result" />
	result: ${result}
	<hr />
	
	<C:if test="${msg == 'user1'}" var="result">
		rest result: ${result}
	</C:if>
	<hr />
	
	<C:if test="${msg == 'user2'}" var="result">
		rest result: ${result}
	</C:if>
	
</body>
</html>