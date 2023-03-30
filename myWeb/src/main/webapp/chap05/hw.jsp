<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>errorThrows.jsp</title>
	<style>
		table, td {
			border:2px solid pink;
			border-collapse: collapse;
		}
		
		td {
			padding: 5px;
			text-align: center;
		}
	</style>
</head>

<body>

	<table>
		<%
			for(int i = 1; i < 10; i++) {
				for(int j = 0; j < 10; j++) {
		%>
			<% 
				if(i == 1) {
			%>
				<td>
					<%= j %>
				</td>
			<%
				}
			%>
			
			<% 
				if(i != 1) {
			%>
		
			<tr>
				<%
					if(j == 0) {
				%>
					<td>
						<%= i + "단" %>
					</td>
				<%
					}
				%>
				
				<td>
					<%= i + " x " + j + " = " + i*j %>
				</td>
			<%	
				}
			%>
		</tr>
		
		<%	}
			}
		%>
		
	</table>
</body>
</html>