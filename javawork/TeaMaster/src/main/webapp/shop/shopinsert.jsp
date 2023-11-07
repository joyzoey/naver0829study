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
		//System.out.println("product="+product);
		String teatype=multipartRequest.getParameter("teatype");
		//System.out.println("teatype="+teatype);
		int price=Integer.parseInt(multipartRequest.getParameter("price"));
		//System.out.println("price="+price);
		int amount=Integer.parseInt(multipartRequest.getParameter("amount"));
		//System.out.println("amount="+amount);
		
		//업로드된 실제 파일명, 업로드 안했을 경우 null
		String photo=multipartRequest.getFilesystemName("upload");
		//System.out.println("photo="+photo);
		
		//null일 경우 "no"라고 저장
		if(photo==null){
			photo="no";
		}		
		
		dto.setProduct(product);
		dto.setTeatype(teatype);
		dto.setPrice(price);
		dto.setAmount(amount);
		dto.setPhoto(photo);
		
		//insert 메서드 호출(db저장)
		dao.insertShop(dto);
		//목록 페이지로 이동(redirect)
		response.sendRedirect("shop.jsp");
		
		} catch(Exception e){
		out.print("<h3>파일 업로드 오류 발생 : "+e.getMessage()+"</h3>");
	}

%>