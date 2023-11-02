<%@page import="student.data.StudentDto"%>
<%@page import="student.data.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name=request.getParameter("name");
	String blood=request.getParameter("blood");
	String phone=request.getParameter("phone");
	
	//dao선언
	StudentDao dao= new StudentDao();
	//dto담기
	StudentDto dto=new StudentDto();
	dto.setName(name);
	dto.setBlood(blood);
	dto.setPhone(phone);
	
	//db저장
	dao.insertStudent(dto);
	//총갯수
	int total=dao.getAllStudent().size();
%>
<data>
	<name><%=name%></name>
	<total><%=total%></total>
</data>