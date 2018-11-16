<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="p02.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1> 고객목록 </h1>
<table border="1">
	<tr>
		<th> 아이디</th>
		<th> 비밀번호</th>
		<th> 이름</th>
		<th> 주민번호 1</th>
		<th> 주민번호 2</th>
		<th> 이메일</th>
		<th> 이메일</th>
		<th> 전호버노</th>
		<th> 주소</th>
		<th> 직업</th>
		
	</tr>
	<!--alias --> 
<jsp:useBean id="memMgr" class="p02.MemberMgrPool"></jsp:useBean>
<!-- return value --> 
<%
	Vector vlist= memMgr.getMemberList();
	
	for( int i=0;i<vlist.size();i++) {
		
	
	MemberDAO memdao=(MemberDAO)vlist.elementAt(i);
%>

	<tr>
		<td><%= memdao.getMem_id() %></td>
		<td><%= memdao.getMem_passwd() %></td>
		<td><%= memdao.getMem_name() %></td>
		<td><%= memdao.getMem_num1() %></td>
		<!-- initially saved as memb_num2 --> 
		<td><%= memdao.getMemb_num2() %></td>
		<td><%= memdao.getMem_email() %></td>
		<td><%= memdao.getMem_phone() %></td>
		<td><%= memdao.getMem_zipcode() %></td>
		<td><%= memdao.getMem_address() %></td>
		<td><%= memdao.getMem_job() %></td>
		
	</tr>
<% 

	}
	
	
%>	
</table>
</body>
</html>