<%@page import="myshop.data.MyshopDto"%>
<%@page import="myshop.data.MyshopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//한글 엔코딩
	request.setCharacterEncoding("utf-8");
	//dao,dto선언
	MyshopDao dao=new MyshopDao();
	MyshopDto dto=new MyshopDto();
	
	//입력값을 읽어서 dto에 담기
	String sangpum=request.getParameter("sangpum");
	String color=request.getParameter("color");
	String photo=request.getParameter("photo");
	int price=Integer.parseInt(request.getParameter("price"));
	int num=Integer.parseInt(request.getParameter("num"));
	
	dto.setSangpum(sangpum);
	dto.setColor(color);
	dto.setPhoto(photo);
	dto.setPrice(price);
	dto.setNum(num);
	
	
	//insert 메서드 호출(db저장)
	dao.updateShop(dto);
	//목록 페이지로 이동(redirect)
	response.sendRedirect("myshop.jsp");

%>