<%@page import="inquireboard.data.InquireBoardDto"%>
<%@page import="inquireboard.data.InquireBoardDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	//한글 엔코딩
	request.setCharacterEncoding("utf-8");
	//dao,dto선언
	InquireBoardDao dao=new InquireBoardDao();
	InquireBoardDto dto=new InquireBoardDto();
	
	//입력값을 읽어서 dto에 담기
	String writer=request.getParameter("writer");
	String phone=request.getParameter("phone");
	String mail=request.getParameter("mail");
	String subject=request.getParameter("subject");
	String content=request.getParameter("content");
	
	//dto에 넣기
	dto.setWriter(writer);
	dto.setPhone(phone);
	dto.setMail(mail);
	dto.setSubject(subject);
	dto.setContent(content);
	
	//insert 메서드 호출(db저장)
	dao.insertBoard(dto);
%>

<script>
    // 알람 표시
    alert("문의가 정상적으로 접수되었습니다. \n담당자가 최대한 빠른 연락 드리도록 하겠습니다.");
    // 목록 페이지로 이동(redirect)
    location.href = "ContactUs.jsp";
</script>