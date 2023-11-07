<%@page import="inquireboard.data.InquireBoardDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	//num
	String num=request.getParameter("num");
	//dao
	InquireBoardDao dao=new InquireBoardDao();
	//delete 메서드 호출
	dao.deleteBoard(num);
	//list.jsp로 이동
	response.sendRedirect("list.jsp");

%>