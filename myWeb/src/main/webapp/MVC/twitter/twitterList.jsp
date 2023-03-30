<%@ page contentType="text/html; charset=UTF-8" 
		 import="java.util.*, mvc.twitter.*"
%>

<%-- 같은 이름의 DAO여서 하나만 만들어짐 --%>
<jsp:useBean id="twitterDAO" class="mvc.twitter.TwitterDAO" scope="session" />
<jsp:useBean id="twitterDO" class="mvc.twitter.TwitterDO" scope="page" />
<jsp:setProperty name="twitterDO" property="message" />

<%
	// 한글 깨짐 방지
	if(request.getMethod().equals("POST")) {
		request.setCharacterEncoding("UTF-8");
	}
%>

<%
	String command = request.getParameter("command");

	// command가 null이면 logout이 되지 않은 것이고 값을 비교할 수 없기 때문에 에러가 발생한다. (= 제어처리 필요)
	if(command != null && command.equals("logout")) {
		// 세션 객체 소멸
		session.invalidate();
		response.sendRedirect("twitterLogin.jsp");
	} else {
		if(command != null && command.equals("twitterInsert")) {
			// object로 들어가고 나오므로 형변환 필요
			// session에 담긴 사용자 id 가져오기
			twitterDO.setId((String)session.getAttribute("id"));
			twitterDAO.insertTwitter(twitterDO);
		}
		
		String result = "";
		ArrayList<TwitterDO> list = twitterDAO.getAllTwitter();
		
		for(TwitterDO tDO : list) {
			result += "<li>" + tDO.getId() + " ::: " + tDO.getMessage() + " ::: " + tDO.getCreateDate() + "</li>";
		}

	
%>

<!DOCTYPE html>

<html>
<head>
   <meta charset="UTF-8">
   <title>twitterList.jsp </title>
</head>
<body>

	<h2>My Simple Twitter!!</h2>
	<hr />
	
	<form method="POST">
		<fieldset>
			<label><%= session.getAttribute("id") %>@<%= session.getAttribute("name") %></label>
			<input type="text" name="message" size="50" />
			<input type="hidden" name="command" value="twitterInsert" />
			<input type="submit" value="등록" />
		</fieldset>
	</form>
	<hr />
	
	<h3>트위터 리스트</h3>
	<ul>	
		<%= result %>
	</ul>
	<hr />
	
	<form method="POST" action="Logout.jsp">
		<input type="hidden" name="command" value="twitterInsert" />
		<input type="submit" value="로그아웃" />
	</form>
	
</body>
</html>

<%
	}
%>