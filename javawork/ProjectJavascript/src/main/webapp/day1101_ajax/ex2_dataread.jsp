<%@page import="myshop.data.MyshopDto"%>
<%@page import="myshop.data.MyshopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sangpum=request.getParameter("sangpum");
	String color=request.getParameter("color");
	String photo=request.getParameter("photo");
	String price=request.getParameter("price");
	
	//dao선언
	MyshopDao dao=new MyshopDao();
	//dto담기
	MyshopDto dto=new MyshopDto();
	dto.setSangpum(sangpum);
	dto.setColor(color);
	dto.setPhoto(photo);
	dto.setPrice(Integer.parseInt(price));
	
	//db저장
	dao.insertShop(dto);
	//총갯수
	int total=dao.getAllSangpums().size();
%>
<data>
	<sangpum><%=sangpum%></sangpum>
	<photo><%=photo%></photo>
	<total><%=total%></total>
</data>	