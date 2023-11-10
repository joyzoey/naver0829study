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
//@RequestMapping("/shop")	//������ ��Ʈ�� �վ���ؼ� ���� ������ �ټ���� ����
public class ShopController {

	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/food/morning/brunch")
	public String list2(Model model){
		
		String message="������ �귱ġ �޴���";
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
		
		
		
		String name="�質��";
		String addr="����� ������";
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
	//public String list(@PathVariable("path") String path)	//:path�� �������� ���� ��� ���� ����
	public String list(@PathVariable String path,Model model)
	{
		//System.out.println(path);
		String shopinfo="";
		
		if(path.equals("list1"))
			shopinfo="���ǽ� ��ǰ ���";
		else if(path.equals("list2"))
			shopinfo="���� ��ǰ ���";
		else
			shopinfo="�Ǽ����� ��ǰ ���";
		
		//��ǰ ��� ���
		List<ShopDto> list=new ArrayList<ShopDto>();
		if(path.equals("list1")) {
			list.add(new ShopDto("ȭ��Ʈ ���ǽ�","2.jpg",99000));
			list.add(new ShopDto("����Ƽ ���ǽ�","25.jpg",45000));
			list.add(new ShopDto("���̽� ���ǽ�","28.jpg",68000));
			list.add(new ShopDto("û ���ǽ�","33.jpg",23000));
		} else if(path.equals("list2")) {
			list.add(new ShopDto("���ڽ���","12.jpg",1500000));
			list.add(new ShopDto("�����","14.jpg",98000));
			list.add(new ShopDto("�÷�����","15.jpg",33000));
		} else {
			list.add(new ShopDto("������","19.jpg",11000));
			list.add(new ShopDto("�Ӹ���","30.jpg",23000));
			list.add(new ShopDto("���ֹ���","21.jpg",55000));
			list.add(new ShopDto("�Ӹ���","26.jpg",9000));
		}
		model.addAttribute("list", list);
		model.addAttribute("count",list.size());
		model.addAttribute("shopinfo", shopinfo);
		return "list1";
	}
}
