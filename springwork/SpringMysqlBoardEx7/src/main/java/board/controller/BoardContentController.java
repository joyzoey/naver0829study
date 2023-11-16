package board.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import board.data.AnswerDao;
import board.data.AnswerDto;
import board.data.BoardDao;
import board.data.BoardDto;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BoardContentController {
	private BoardDao boardDao;
	private AnswerDao answerDao;
	
	//내용페이지로 이동
	@GetMapping("/simple/content")
	public String content(Model model, @RequestParam int num)
	{
		//조회수 증가
		boardDao.updateReadcount(num);
		//dto얻기
		BoardDto dto=boardDao.getData(num);
		//해당 글에 대한 댓글 가져오기
		List<AnswerDto> alist=answerDao.getAnswers(num);
		//model에 저장
		model.addAttribute("dto",dto);
		model.addAttribute("alist",alist);
		model.addAttribute("acount",alist.size());//댓글갯수
		return "content";
	}
	
	//db에서삭제 redirect 목록페이지 재접속
	@GetMapping("/simple/delete")
	public String delete(@RequestParam int num)
	{
		boardDao.deleteBoard(num);
		return "redirect:./list";
	}
	
	//수정페이지로 이동
	@GetMapping("/simple/updateform")
	public String updateForm(Model model, @RequestParam int num)
	{
		//num에 해당하는 dto얻기
		BoardDto dto=boardDao.getData(num);
		//dto를 모델에 저장
		model.addAttribute("dto",dto);
		return "updateform";
	}
	
	//db수정 redirect 내용페이지 재접속
	@PostMapping("/simple/updateprocess")
	public String update(@ModelAttribute BoardDto dto, @RequestParam MultipartFile upload,
			HttpServletRequest request)
	{
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
		//사진을 선택하지 않을 경우 photo에 null
		String photo="";
		if(upload.getOriginalFilename().equals(""))
			dto.setPhoto(null);
		else {
			//랜덤파일명을 photo에 저장
			photo=UUID.randomUUID().toString();
			dto.setPhoto(photo);
		}
		try {
			upload.transferTo(new File(path+"/"+photo));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boardDao.updateBoard(dto);//db수정
		
		return "redirect:./content?num="+dto.getNum();
	}
	
	//댓글 추가 redirect 내용페이지 재접속
	@PostMapping("/simple/addanswer")
	public String addAnswer(@ModelAttribute AnswerDto dto)
	{
		answerDao.insertAnswer(dto);
		return "redirect:./content?num="+dto.getNum();
	}
	
	//댓글 삭제 redirect 내용페이지 재접속
	@GetMapping ("/simple/answerdel")
	public String deleteAnswer(@RequestParam int num, @RequestParam int idx)
	{
		answerDao.deleteAnswer(idx);
		return "redirect:./content?num="+num;
	}
}
	
