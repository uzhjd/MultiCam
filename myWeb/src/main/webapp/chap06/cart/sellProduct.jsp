<%@ page contentType="text/html; charset=UTF-8" %>

<%
	/*
		selProduct의 보안 사항
		1. 로그인한 사용자만 이용할 수 있다.
		2. 로그인 안한 사용자가 접근할 경우: 로그인 페이지로 리다이렉팅 한다.
		3. 로그아웃 기능 추가
	*/	
%>

<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>sellProduct.jsp</title>
</head>

<body>

	<h1>상품구매</h1>
	<hr />
	
	<h4><%= session.getAttribute("userId") %>님을 환영합니다...^^</h4>
	
	<form action="add.jsp" method="POST">
	<fieldset>
	<legend> 상품 선택</legend>
		<select name="product">
			<option selected>사과</option>
			<option>딸기</option>
			<option>배</option>
			<option>포도</option>
			<option>오렌지</option>
			<option>수박</option>	
		</<select>
		<input type="submit" value="cnrk" />
		</fieldset>
	</form>
	
	
	<hr />
	
	<h4><a href="checkOut.jsp">장바구니 확인</a></h4>
</body>
</html>