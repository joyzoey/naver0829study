<%@page import="inquireboard.data.InquireBoardDto"%>
<%@page import="inquireboard.data.InquireBoardDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	//�ѱ� ���ڵ�
	request.setCharacterEncoding("utf-8");
	//dao,dto����
	InquireBoardDao dao=new InquireBoardDao();
	InquireBoardDto dto=new InquireBoardDto();
	
	//�Է°��� �о dto�� ���
	String writer=request.getParameter("writer");
	String phone=request.getParameter("phone");
	String mail=request.getParameter("mail");
	String subject=request.getParameter("subject");
	String content=request.getParameter("content");
	
	//dto�� �ֱ�
	dto.setWriter(writer);
	dto.setPhone(phone);
	dto.setMail(mail);
	dto.setSubject(subject);
	dto.setContent(content);
	
	//insert �޼��� ȣ��(db����)
	dao.insertBoard(dto);
%>

<script>
    // �˶� ǥ��
    alert("���ǰ� ���������� �����Ǿ����ϴ�. \n����ڰ� �ִ��� ���� ���� �帮���� �ϰڽ��ϴ�.");
    // ��� �������� �̵�(redirect)
    location.href = "ContactUs.jsp";
</script>