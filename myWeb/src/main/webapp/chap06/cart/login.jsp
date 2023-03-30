<%@ page  contentType="text/html; charset=UTF-8" %>

<%
		/*
			로그인 예제의 보완 사항
			-> 로그인 화면은 로그인 하지 않은 사용자에게만 보여야 한다!
			=> 로그인 한 사용자가 로그인 화면을 요청하는 경우 selProduct로 리다이렉팅시킨다.
		*/
%>	

<%
   final String ID = "longlee";
   final String PASSWD = "6789";
   boolean isLogin = false;
   
   if(request.getMethod().equals("POST")){
      String id = request.getParameter("id");
      String passwd = request.getParameter("passwd");
      
      if(id != null && id.equals(ID) && passwd != null && passwd.equals(PASSWD)){
         session.setAttribute("userId",id);
         isLogin = true;
         response.sendRedirect("selProduct.jsp");
      }
   }
      
%>

<!DOCTYPE html>

<html>
<head>
   <meta charset="UTF-8">
   <title>login.jsp </title>
</head>

<body>
   <h1>로그인</h1>
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