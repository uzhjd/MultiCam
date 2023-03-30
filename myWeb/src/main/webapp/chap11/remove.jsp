<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>JSTL: remove</title>
</head>

<body>

	<h2>JSTL c:remove</h2>
	<hr />
	
	<c:set var="msg" value="Hello, World!" />
	msg(삭제 전): {msg}<br />
	
	<c:remove var="msg" />
	msg(삭제 후): {msg}<br />
	
	
</body>
</html>