<?xml version="1.0" encoding="UTF-8"?>
<%@page import="teashop.data.TeaShopDto"%>
<%@page import="teashop.data.TeaShopDao"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<data>

<%
	//dao선언
	TeaShopDao myShopDao=new TeaShopDao();
	List<TeaShopDto> list=myShopDao.getAllproducts();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	for(TeaShopDto dto:list)
	{%>
		<shop>
			<product num="<%=dto.getNum()%>"><%=dto.getProduct()%></product>
			<teatype><%=dto.getTeatype() %></teatype>
			<price><%=dto.getPrice() %></price>
			<amount><%=dto.getAmount() %></amount>
			<photo><%=dto.getPhoto() %></photo>
			<writeday><%=sdf.format(dto.getWriteday()) %></writeday>
		</shop>
	<%}
%>
</data>