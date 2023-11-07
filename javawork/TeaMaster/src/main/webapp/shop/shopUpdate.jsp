<%@page import="teashop.data.TeaShopDto"%>
<%@page import="teashop.data.TeaShopDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MultipartRequest multipartRequest=null;	

	//String realPath = "D:/naver0829/studywork/TeaMaster/src/main/webapp/shop";
	getServletContext().getRealPath("/shop");
	String realPath =getServletContext().getRealPath("/shop");
	//System.out.println("path="+realPath);
	int uploadSize=1024*1024*5;//5mb

	
	try{
		multipartRequest=new MultipartRequest(request,realPath,uploadSize,"utf-8",
				new DefaultFileRenamePolicy());
		
		//한글 엔코딩
		request.setCharacterEncoding("utf-8");
		//dao,dto선언
		TeaShopDao dao=new TeaShopDao();
		TeaShopDto dto=new TeaShopDto();
		
		//입력값을 읽어서 dto에 담기
		String product=multipartRequest.getParameter("product");
		String teatype=multipartRequest.getParameter("teatype");
		int price=Integer.parseInt(multipartRequest.getParameter("price"));
		int amount=Integer.parseInt(multipartRequest.getParameter("amount"));
		String photo=multipartRequest.getParameter("photo");
		int num=Integer.parseInt(multipartRequest.getParameter("num"));
		
		dto.setProduct(product);
		dto.setTeatype(teatype);
		dto.setPrice(price);
		dto.setAmount(amount);
		dto.setPhoto(photo);
		dto.setNum(num);
		
		//update 메서드 호출(db저장)
		dao.updateShop(dto);
		//목록 페이지로 이동(redirect)
		response.sendRedirect("shopDetail.jsp?num="+num);

	} catch(Exception e){
		out.print("<h3>파일 업로드 오류 발생 : "+e.getMessage()+"</h3>");
	}
%>