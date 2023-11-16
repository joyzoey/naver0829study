package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import board.data.AnswerDao;
import board.data.BoardDao;
import board.data.BoardDto;
import lombok.AllArgsConstructor;

@Controller
//@AllArgsConstructor //생성자주입
public class BoardListController {
	@Autowired //null값출력
	private BoardDao boardDao;
	@Autowired
	private AnswerDao anwerDao;
	
	//목록페이지로 이동
	@GetMapping("/simple/list")
	public String list(Model model)
	{
		//전체 갯수 가져오기
		int totalCount=boardDao.getTotalCount();
		//전체 데이터 가져오기
		List<BoardDto> list=boardDao.getAllDatas();
		//list의 acount에 각 글에 대한 댓글 갯수 저장하기
		for(BoardDto dto:list)
		{
			dto.setAcount(anwerDao.getAnswers(dto.getNum()).size());
		}
		
		
		//model에 저장
		model.addAttribute("totalCount",totalCount);
		model.addAttribute("list",list);
		return "list";
	}
}
