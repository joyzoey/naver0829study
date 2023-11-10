package study.day1109.mvc3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/shop")	//지금은 루트가 잇어야해서 전부 샵ㅇ로 줄수없어서 뺄것
public class ShopController {

	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/food/morning/brunch")
	public String list2(Model model){
		
		String message="오늘의 브런치 메뉴들";
		List<String> list=new ArrayList<String>();
		list.add("K-039.png");
		list.add("K-041.png");
		list.add("K-042.png");
		
		model.addAttribute("message",message);
		model.addAttribute("today",new Date());
		model.addAttribute("list",list);
		return "list2";
	}
	
	@GetMapping("/food/photo/detail")
	public String list3(Model model){
		
		
		
		String name="김나혜";
		String addr="서울시 강남구";
		List<String> food=new ArrayList<String>();
		food.add("K-039.png");
		food.add("K-041.png");
		food.add("K-042.png");
		
		model.addAttribute("name",name);
		model.addAttribute("addr",addr);
		model.addAttribute("food",food);
		return "list3";
	}
	
	
	
	@GetMapping("/shop/{path}")
	//public String list(@PathVariable("path") String path)	//:path와 변수명이 같을 경우 생략 가능
	public String list(@PathVariable String path,Model model)
	{
		//System.out.println(path);
		String shopinfo="";
		
		if(path.equals("list1"))
			shopinfo="원피스 상품 목록";
		else if(path.equals("list2"))
			shopinfo="슈즈 상품 목록";
		else
			shopinfo="악세서리 상품 목록";
		
		//상품 목록 담기
		List<ShopDto> list=new ArrayList<ShopDto>();
		if(path.equals("list1")) {
			list.add(new ShopDto("화이트 원피스","2.jpg",99000));
			list.add(new ShopDto("스포티 원피스","25.jpg",45000));
			list.add(new ShopDto("레이스 원피스","28.jpg",68000));
			list.add(new ShopDto("청 원피스","33.jpg",23000));
		} else if(path.equals("list2")) {
			list.add(new ShopDto("샤넬슈즈","12.jpg",1500000));
			list.add(new ShopDto("구찌슈즈","14.jpg",98000));
			list.add(new ShopDto("플렛슈즈","15.jpg",33000));
		} else {
			list.add(new ShopDto("리본핀","19.jpg",11000));
			list.add(new ShopDto("머리띠","30.jpg",23000));
			list.add(new ShopDto("진주반지","21.jpg",55000));
			list.add(new ShopDto("머리끈","26.jpg",9000));
		}
		model.addAttribute("list", list);
		model.addAttribute("count",list.size());
		model.addAttribute("shopinfo", shopinfo);
		return "list1";
	}
}
