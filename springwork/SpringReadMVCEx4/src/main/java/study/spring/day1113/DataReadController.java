package study.spring.day1113;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DataReadController {

	@GetMapping("/process1")
	//@RequestParam("���±��� name") String ������ : ���±��� name�� �������� ���� ���, name�� ���� ����
	//@RequestParam ��ü�� ��� ������ �����ϴ�(������ �ٸ� ������̼����� �߸� �ν��ϴ� ��츦 �����ϱ� ���� �������ϴ� �� ���� ��)
	public String process1(Model model,@RequestParam("name") String irum,@RequestParam String addr, @RequestParam int age)
	{
		model.addAttribute("name",irum);
		model.addAttribute("addr",addr);
		model.addAttribute("age",age+"���� "+(age>=20?"����":"�̼�����")+"�Դϴ�");
		return "result1";
	}
	
//	public String process1(HttpServletRequest request, Model model)
//	{
//		//jspó�� �о��(������������ �̷��� ���� ����)
//		String name=request.getParameter("name");
//		String addr=request.getParameter("addr");
//		int age=Integer.parseInt(request.getParameter("age"));
//		
//		model.addAttribute("name",name);
//		model.addAttribute("addr",addr);
//		model.addAttribute("age",age+"���� "+(age>=20?"����":"�̼�����")+"�Դϴ�");
//		
//		return "result1";
//	}
	
	@PostMapping("/process2")
	public String process2(Model model, @RequestParam String message, @RequestParam String animal
			/*���±׿� name�̶�� �±״� ����*/
			, @RequestParam(defaultValue="�ٴϿ�"/*null�� �⺻�� �ٴϿ�*/, required = false/*null�� �������ֱ�*/) String name)
			/*null���� �������� ������ �ȳ��� �ϰ� ���� ���(�����ڵ� 400), require=false
			 * null�� ��� �⺻���� �־� �ְ� ���� ���, defaultValue="�⺻ ��", �̰� ���� ���� require�� ��� ��*/
	{
		System.out.println(name);
		model.addAttribute("name",name);
		model.addAttribute("message",message);
		model.addAttribute("animal",animal);
		return "result2";
	}
	
	//@ModelAttribute : dto�� ���� �̸��� ���±׸� �о �𵨿� �����Ѵ�
	@PostMapping("/process3")
	public String process3(@ModelAttribute ShopDto dto, @RequestParam String today, Model model) //model�� shopDto��� �̸����� ����
	//public String process3(@ModelAttribute ("dto") ShopDto dto) //model�� Dto��� �̸����� ����
	{
		model.addAttribute("today",today);
		return "result3";
	}
	
	@PostMapping("/process4")
	public String process4(Model model, @RequestParam Map<String, String> map)//���±��� name�� key�� �Է°��� value�� ����
	{
		model.addAttribute("sang",map.get("sang"));
		model.addAttribute("su",map.get("su"));
		model.addAttribute("dan",map.get("dan"));
		model.addAttribute("color",map.get("color"));
		model.addAttribute("photo",map.get("photo"));
		model.addAttribute("today",map.get("today"));
		
		return "result4";
	}
}
