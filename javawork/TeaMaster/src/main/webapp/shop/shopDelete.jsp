<%@page import="teashop.data.TeaShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	//num 읽기
	String num=request.getParameter("num");
	//dao 선언
	TeaShopDao dao=new TeaShopDao();
	//delete 메서드 호출
	dao.deleteShop(num);
	//myshop.jsp로 리다이렉트로 이동
	response.sendRedirect("shop.jsp");

%>