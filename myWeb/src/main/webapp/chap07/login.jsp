<%@ page contentType="text/html; charset=UTF-8" 
      import="chap07.LoginBean"
%>

<jsp:useBean id="loginBean" class="chap07.LoginBean" scope="page" />
<jsp:setProperty name="loginBean" property="*" />

<%--
<jsp:setProperty name="loginBean" property="id" />
<jsp:setProperty name="loginBean" property="pw" />
--%>

<%
   // LoginBean loginBean = new LoginBean();

   // loginBean.setId(request.getParameter("id"));
   // loginBean.setPasswd(request.getParameter("pw"));
   String msg = "";
   
   if(loginBean.checkLogin()) {
      msg += "<h4>" + loginBean.getId() + "님의 방문을 환영합니다.</h4>";
      msg += "<h5>id: " + loginBean.getId() + ", 패스워드: " + loginBean.getPw() + "</h5>";
   }
   else {
      msg += "<h4>로그인을 실패했습니다 ... 다시 로그인 해주세요</h4>";
      msg += "<a href='loginForm.html'>로그인</a>";
   }
%>

<!DOCTYPE html>

<html>
<head>
   <meta charset="UTF-8">
   <title>Insert title here</title>
</head>

<body>

   <h1>로그인 결과</h1>
   <hr />

   <%= msg %>
	<h5>id: <jsp:getProperty name="loginBean" property="id" />,
		pw: <jsp:getProperty name="loginBean" property="pw" />
	</h5>
</body>
</html>