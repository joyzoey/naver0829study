<%@page import="inquireboard.data.InquireBoardDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	//num
	String num=request.getParameter("num");
	//dao
	InquireBoardDao dao=new InquireBoardDao();
	//delete �޼��� ȣ��
	dao.deleteBoard(num);
	//list.jsp�� �̵�
	response.sendRedirect("list.jsp");

%>