<%@ page contentType="text/html; charset=UTF-8" 
		 import="java.sql.*"
%>

<%
	String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
	String jdbc_url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "scott";
	String pwd = "tiger";
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	String list = "";
	
	try {
		Class.forName(jdbc_driver);
		conn = DriverManager.getConnection(jdbc_url, user, pwd);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	sql = "select * from jdbc_test";
	
	try {
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			list += "<li>" + rs.getString("username") + " | " + rs.getString("email") + "</li>";
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if(!pstmt.isClosed()) {
				pstmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 등록 기능을 구현하는 코드르 작성하세요.
	if(request.getMethod().equals("POST")) {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		sql = "insert into jdbc_test values(?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("username"));
			pstmt.setString(2, request.getParameter("email"));
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(!pstmt.isClosed()) {
					pstmt.close();
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		try {
			if(!conn.isClosed()) {
				conn.close();
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
%>

<!DOCTYPE html>

<html>
<head>
   <meta charset="UTF-8">
   <title>jdbc_test.jsp</title>
</head>

<body>

   <h1>JDBC Test v1</h1>
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
   
   <ol>
   		<%= list %>
   </ol>
   
</body>
</html>