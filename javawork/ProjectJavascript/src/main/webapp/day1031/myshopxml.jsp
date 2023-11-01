<?xml version="1.0" encoding="UTF-8"?>
<%@page import="java.util.List"%>
<%@page import="myshop.data.MyshopDto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="myshop.data.MyshopDao"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<data>

<%
	//dao선언
	MyshopDao myShopDao=new MyshopDao();
	List<MyshopDto> list=myShopDao.getAllSangpums();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	for(MyshopDto dto:list)
	{%>
		<myshop>
			<sangpum num="<%=dto.getNum()%>"><%=dto.getSangpum()%></sangpum>
			<price><%=dto.getPrice() %></price>
			<photo><%=dto.getPhoto() %></photo>
			<color><%=dto.getColor() %></color>
			<writeday><%=sdf.format(dto.getWriteday()) %></writeday>
		</myshop>
	<%}
%>
</data>