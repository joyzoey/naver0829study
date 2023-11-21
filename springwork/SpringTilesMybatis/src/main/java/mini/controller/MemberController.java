package mini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import mini.dao.MemberDao;

@Controller
@RequiredArgsConstructor
public class MemberController {

	@NonNull
	private MemberDao memberDao;
	
	@GetMapping("/member/form")
	public String memberform()
	{
		return "member/memberform";
	}
	
	@GetMapping("/member/list")
	public String memberList(Model model)
	{
		//ÃÑ ¸â¹ö¼ö ¾ò±â
		int totalCount=memberDao.getTotalCount();
		model.addAttribute("totalCount",totalCount);
		return "member/memberlist";
	}
	
}
