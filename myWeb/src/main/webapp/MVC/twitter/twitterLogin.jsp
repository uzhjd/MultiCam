<%@ page contentType="text/html; charset=UTF-8" 
		 import="mvc.twitter.*"
%>

<%-- LoginDO와 연결: 새로운 요청이 들어올때마다 DO를 새롭게 다시 만들어 줌. --%>
<jsp:useBean id="LoginDO" class="mvc.twitter.TwitterLoginDO" scope="page" />
<%-- 이름이 같은 얘들을 자동으로 매핑시켜줌 --%>
<jsp:setProperty name="LoginDO" property="*" />
<jsp:useBean id="twitterDAO" class="mvc.twitter.TwitterDAO" scope="session" />

<%
	if(request.getMethod().equals("POST")) {
		TwitterLoginDO result = twitterDAO.checkLogin(LoginDO);
		if(result != null) {
			session.setAttribute("id", result.getId());
			session.setAttribute("name", result.getName());
			
			// 페이지 이동
			response.sendRedirect("twitterList.jsp");
		}
	}
%>

<!DOCTYPE html>

<html>
<head>
   <meta charset="UTF-8">
   <title>twitterLogin.jsp </title>
</head>

<body>

   <h1>트위터 로그인</h1>
   <hr/>
   
   <form method = "POST">
   <fieldset>
      <label for = "id">ID</label>
      <input type = "text" name = "id" id = "id"/>
      
      <label for = "passwd">/ Password</label>
      <input type = "password" name = "passwd" id = "passwd"/>
      
      <input type = "submit" value = "login"/>
   </fieldset>
   </form>
   
</body>
</html>