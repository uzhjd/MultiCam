<%@ page contentType="text/html; charset=UTF-8"
		 import="chap11.*"
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>JSTL: for</title>
</head>

<body>

	<h2>JSTL c:for</h2>
	<hr />
	
	<c:forEach items="${members}" var="member" begin="4" ends="9" varStatus="status">
		index: ${status.index} / count: ${status.count}<br />
		name: ${memebrs.name}<br />
		email: ${member.email}<br />
		<hr />
	</c:forEach>

	<c:forTokens items="손흥민, 101-1234-1234, 서울, 축구선수" delims="," var="token">
		${token}<br />
	</c:forTokens>
</body>
</html>