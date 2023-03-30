<%@ page contentType="text/html; charset=UTF-8" %>

<%
	// String myName = "김연아"; 이렇게 하면 el이 안먹고 <%= 로 해야 하는데 그건 노노
	request.setAttribute("myName", "김연아");
%>

<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>elResult.jsp</title>
</head>

<body>

	<h2>EL Result</h2>
	<hr />
	
	${pageScope.pageElTest}<br />
	${requestScope.reqElTest}<br />
	${sessionScope.sesElTest}<br />
	${applicationScope.appElTest}<br />
	${param.userName}<br />
	${paramValues.favorite[0]} / ${paramValues.favorite[1]}<br />
	${cookie.elCookie.name} = ${cookie.elCookie.value}<br />
	adminID: ${initParam.adminID} / adminPasswd: ${initParam.adminPasswd}<br />
	<!--  사용자 이름: ${muName}<br /> el표현식은 로컬변수를 사용할 수 X (영역자체가 다름.)-->
	<!--사용자 이름: myName <br /> 이거는 되지만 이 대신에 request, pagecontext를 쓰기 -->
	사용자 이름: ${muName}<br />
	
</body>
</html>