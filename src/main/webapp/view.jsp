<%@page import="com.mindtree.model.Employee"%>
<%@page import="java.util.LinkedList"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="index.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>View Page</title>
</head>
<body>
	<%
	List<Employee> emp = new LinkedList<>();
	%>
	<%
	String empToJson = null;
	%>
	<%
	emp = (List<Employee>) session.getAttribute("emp");
	%>
	<%
	empToJson = (String) session.getAttribute("empToJson");
	%>
	<%
	out.println(emp.toString());
	%>
	<%
	out.println(empToJson);
	%>
</body>
</html>