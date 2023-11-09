package study.day1109.mvc1;



import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //자동으로 xml 설정파일에 bean이 등록
public class TestController {
	
	
	//@RequestMapping("/") //기본이 get방식 : 초기 버전부터 모두 가능한 어노테이션
	@GetMapping("/") //스프링 버전 5부터 가능한 어노테이션
	public String home(Model model)
	{
		model.addAttribute("message","Have a Good Time!"); //request에 저장
		model.addAttribute("today",new Date());
		return "result1";
	}
	
	//@GetMapping("/shop/list") //  /shop/list.*모두 호출 가능
	//@GetMapping("/shop/list.do") //  /shop/list.do만 호출 가능
	@GetMapping("/shop/{path1}")	//	PathVariable("path1"):path1으로 넘어온 url 값을 읽음
	public String go(Model model,@PathVariable("path1") String p1)
	{
		//System.out.println(p1);
		model.addAttribute("path","/shop/"+p1);
		return "list";
	}
	
	//@GetMapping("/board/update")
	@GetMapping ({"/board/update","/stu/form/test1"}) //두개의 매핑이 같은 곳으로 포워드한다
	public ModelAndView hello(HttpServletRequest request) // model and view : 모델역할도 하고 뷰역할도 함
	{
		//프로젝트 명까지의 경로를 얻는다
		String root=request.getContextPath();
		//System.out.println(root); //	루트 주소값뒤에 /가 있는지 확인
		
		ModelAndView mview=new ModelAndView();
		mview.addObject("message", "매핑주소로 사진을 나타내보자");
		mview.addObject("root",root); //루트라는 이름으로 루트의 값을 모델에다 저장
		mview.setViewName("result2");
		return mview;
	}
}
