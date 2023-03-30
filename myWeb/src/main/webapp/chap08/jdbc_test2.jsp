<%@ page contentType="text/html; charset=UTF-8"
		 import="chap08.*, java.util.*"
%>
<%
	// setproperty전에 디코딩해줘야 함_POST방식 일때만
	if(request.getMethod().equals("POST")) {
      request.setCharacterEncoding("UTF-8");
	}

	//필터를 사용하면 위의 코드 작성 안 해줘도 되공 'POST'방식으로 들어오면 자동으로 디코딩해줌. _아직 안배움..
%>
<jsp:useBean id="dao" class="chap08.JdbcTestDAO" scope="session" />
<jsp:useBean id="testDO" class="chap08.JdbcTestDO" scope="page" />
<jsp:setProperty name="testDO" property="*" />

<%
	// java Beans와 action을 이용하여 동일한 기능을 구현하는 코드를 작성하세요.
	if(request.getMethod().equals("POST")) {
		dao.insertJdbcTest(testDO);
	}

	ArrayList<JdbcTestDO> list = dao.selectAllJdbcTest();
	String result= "";

	for(JdbcTestDO tdo: list) {
		result += "<li>" + tdo.getUsername() + " | " + tdo.getEmail() + "</li>";	
	}
%>

<!DOCTYPE html>

<html>
<head>
   <meta charset="UTF-8">
   <title>jdbc_test.jsp</title>
</head>

<body>

   <h1>JDBC Test v2</h1>
   <hr />

   <form method="POST">
	   <fieldset>
	   		<legend>사용자 등록</legend>
	   		
	   		<label for="username">이름</label>
	   		<input type for="text" name="username" id="username" />
	   		
	   		<label for="email">이메일</label>
	   		<input type for="text" name="email" id="email" />
	   		
	   		<input type="submit" value="등록" />
	   </fieldset>
   </form>
   
   <hr />
   
   <h3>등록 목록</h3>
   	<%= result %>
   <ol>
   
   </ol>
   
</body>
</html>