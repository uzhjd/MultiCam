<%@ page contentType="text/html; charset=UTF-8" %>


<%
	Cookie[] cookies = request.getCookies();
	String result = "";
	
	for(Cookie cookie : cookies) {
		result += "<h4>name: " + cookie.getName() + " / value: " + cookie.getValue() + "</h4>";
	}
%>

<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>cookieResult.jsp</title>
</head>

<body>

	<h1>쿠키 확인</h1>
	<hr />
	
	<%=
		//오청에 포함된 모든 쿠키의 이름과 값을 추력하는 코드를 작성하세요.
		result
	%>
	
</body>
</html>