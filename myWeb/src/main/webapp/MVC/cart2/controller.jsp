<%@ page contentType="text/html; charset=UTF-8" %>

<jsp:useBean id="bean" class="mvc.cart.CartBean" scope="session" />

<%
	if(request.getMethod().equals("POST")) {
		request.setCharacterEncoding("UTF-8");
	}

	String command = request.getParameter("command");
	String viewPath = "/WEB-INF/views/cart2/";
	
	if(session.getAttribute("id") == null) { // login X
		if(request.getMethod().equals("GET")) {
			pageContext.forward(viewPath + "login.jsp");
			
		}
		else if (request.getMethod().equals("POST")){
			String id = request.getParameter("id");
			String passwd = request.getParameter("passwd");
			
			if(bean.checkLogin(id, passwd)) { // login success
				session.setAttribute("id", id);
			
				pageContext.forward(viewPath + "sellProduct.jsp");
			} else { // login fail
				// 브라우저가 서버에 다시 요청을 보내는 것 _sendRedirect
				response.sendRedirect("controller.jsp");
			}
			
		}
	} else if(command != null && command.equals("logout")) {
		session.invalidate();

		response.sendRedirect("controller.jsp");
	} else if(command != null && command.equals("addCart")) {
		String product = request.getParameter("product");
		bean.addProduct(product);

		request.setAttribute("script", "alert('" + product + " 상품을 구매했습니다.');");
		pageContext.forward(viewPath + "sellProduct.jsp");
	}  else if(command != null && command.equals("checkOut")) {
		if(session.getAttribute("productList") == null) {
			session.setAttribute("productList", bean.getProductList());
			
		}
		pageContext.forward(viewPath + "checkOut.jsp");
	} else if(command != null && command.equals("clearCart")) {
		bean.clearProductList();
		pageContext.forward(viewPath + "sellProduct.jsp");
	} else {

		pageContext.forward(viewPath + "sellProduct.jsp");
	}
%>

<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		<%= request.getAttribute("script") %>
	</script>
</head>

<body>

	
	
</body>
</html>