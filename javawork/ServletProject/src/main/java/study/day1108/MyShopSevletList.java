package study.day1108;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myshop.dto.MyshopDto;

/**
 * Servlet implementation class MyShopSevlet
 */
@WebServlet("/cjhome/myshop/list")
public class MyShopSevletList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    List<MyshopDto> list=new Vector<MyshopDto>();
	
    public MyShopSevletList() {
        super();
        list.add(new MyshopDto(100, "자켓", "32.jpg", 34000, "pink"));
        list.add(new MyshopDto(200, "머리띠", "30.jpg", 19000, "orange"));
        list.add(new MyshopDto(300, "단화", "14.jpg", 56000, "green"));
        list.add(new MyshopDto(400, "원피스", "25.jpg", 27000, "margenta"));
        list.add(new MyshopDto(500, "머리끈", "26.jpg", 11000, "yellow"));
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setAttribute("total", list.size());
		request.setAttribute("list", list);
		request.setAttribute("total", new Date());
		
		//포워드
		RequestDispatcher rd=request.getRequestDispatcher("../../day1108/myshoplist.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
