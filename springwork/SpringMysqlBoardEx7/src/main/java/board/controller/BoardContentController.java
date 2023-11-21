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
	
	//������������ �̵�
	@GetMapping("/simple/content")
	public String content(Model model, @RequestParam int num)
	{
		//��ȸ�� ����
		boardDao.updateReadcount(num);
		//dto���
		BoardDto dto=boardDao.getData(num);
		//�ش� �ۿ� ���� ��� ��������
		List<AnswerDto> alist=answerDao.getAnswers(num);
		//model�� ����
		model.addAttribute("dto",dto);
		model.addAttribute("alist",alist);
		model.addAttribute("acount",alist.size());//��۰���
		return "content";
	}
	
	//db�������� redirect ��������� ������
	@GetMapping("/simple/delete")
	public String delete(@RequestParam int num)
	{
		boardDao.deleteBoard(num);
		return "redirect:./list";
	}
	
	//������������ �̵�
	@GetMapping("/simple/updateform")
	public String updateForm(Model model, @RequestParam int num)
	{
		//num�� �ش��ϴ� dto���
		BoardDto dto=boardDao.getData(num);
		//dto�� �𵨿� ����
		model.addAttribute("dto",dto);
		return "updateform";
	}
	
	//db���� redirect ���������� ������
	@PostMapping("/simple/updateprocess")
	public String update(@ModelAttribute BoardDto dto, @RequestParam MultipartFile upload,
			HttpServletRequest request)
	{
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
		//������ �������� ���� ��� photo�� null
		String photo="";
		if(upload.getOriginalFilename().equals(""))
			dto.setPhoto(null);
		else {
			//�������ϸ��� photo�� ����
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
		boardDao.updateBoard(dto);//db����
		
		return "redirect:./content?num="+dto.getNum();
	}
	
	//��� �߰� redirect ���������� ������
	@PostMapping("/simple/addanswer")
	public String addAnswer(@ModelAttribute AnswerDto dto)
	{
		answerDao.insertAnswer(dto);
		return "redirect:./content?num="+dto.getNum();
	}
	
	//��� ���� redirect ���������� ������
	@GetMapping ("/simple/answerdel")
	public String deleteAnswer(@RequestParam int num, @RequestParam int idx)
	{
		answerDao.deleteAnswer(idx);
		return "redirect:./content?num="+num;
	}
}
	