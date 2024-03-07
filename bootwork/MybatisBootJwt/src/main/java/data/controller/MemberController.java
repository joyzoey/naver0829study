package data.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import data.dto.MemberDto;
import data.service.MemberService;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;

@RestController
@RequiredArgsConstructor
@CrossOrigin // 옛날에는 이게 반드시 필요했는데, 지금은 그냥 없어도 되는듯?
public class MemberController {

	//변수
	private final MemberService memberService;
	private final NcpObjectStorageService storageService;
	private final PasswordEncoder passwordEncoder;//비밀번호 암호화
	private String bucketName = "bitcamp-nhkim";
	private String folderName = "reactboot";
	private String uploadFilename;// 업로드 파일명
	
	
	//멤버 리스트
	@GetMapping("/member/list")
	public Map<String, Object> list()
	{
		Map<String, Object> map = new HashMap<>();
		int totalCount = memberService.getTotalCount();
		List<MemberDto> mlist = memberService.getAllMembers();
		
		map.put("totalCount", totalCount);
		map.put("mlist", mlist);
		
		return map;
	}
	
	// 파일 업로드 - 가입 시 사진 저장
	@PostMapping("/member/upload")
	public String uploadFile(@RequestParam("upload") MultipartFile upload)
	{
		uploadFilename = storageService.uploadFile(bucketName, folderName, upload);
		
		return uploadFilename;
	}
	
	//멤버 추가
	@PostMapping("/member/insert")
	public String insert(@RequestBody MemberDto dto)
	{
		//pass 는 암호화해서 db 에 저장
		String pass=dto.getPass();
		String pass1=passwordEncoder.encode(pass);
		System.out.println("비번 암호화:"+pass1);

		//dto 의 pass를 암호화된 pass로 변경
		dto.setPass(pass1);
		//업로드된 사진
		dto.setPhoto(uploadFilename);
		
		memberService.insertMember(dto);
		uploadFilename = null;
		return "success";
	}
	
	//아이디 중복 체크 - 아이디가 db 에 존재하면 1, 존재하지 않을경우 0 이 반환
	@GetMapping("/member/idcheck")
	public int idcheck(@RequestParam("myid") String myid)
	{
		return memberService.getIdCheck(myid);
	}
	
	//멤버삭제
	@DeleteMapping("/member/delete")
	public void delete(@RequestParam("num") int num)
	{
		//db 삭제전에 스토리지의 사진부터 먼저 삭제
		String dbPhotoname=memberService.getMember(num).getPhoto();
		storageService.deleteFile(bucketName, folderName, dbPhotoname);

		//db 삭제
		memberService.deleteMember(num);
	}
}
