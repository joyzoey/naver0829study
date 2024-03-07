package data.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.cj.x.protobuf.MysqlxSession.AuthenticateContinue;

import data.dto.MemberDto;
import data.service.MemberService;
import lombok.RequiredArgsConstructor;
import security.setting.JwtTokenProvider;
import security.setting.UserAuthentication;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class LoginController {

	private final MemberService memberService;
	private final PasswordEncoder passwordEncoder;
	
	@PostMapping("/login/auth")
	public Map<String,Object> login(@RequestBody MemberDto dto)
	{
		System.out.println("myid="+dto.getMyid()+",pass="+dto.getPass());
		Map<String, Object> map = new HashMap<>();
		//해당 아이디에 대한 멤버가 있는지 가져오기
		MemberDto dto2 = memberService.getLogin(dto.getMyid());
		if(dto2==null) {
			//해당 아이디 없는 경우
			map.put("result", "noid");
		}
		else {
			//해당 아이디가 있는 경우 비번을 얻어서 비교
			//맞을경우 토큰을 얻어서 보내기(result:success)
			String dbPass = dto2.getPass();
			String myid=dto.getMyid();
			String pass=dto.getPass();//로그인시 입력한 비번
			Boolean b = passwordEncoder.matches(pass, dbPass);
			if(b) {
				map.put("result", "success");
				Authentication auth = new UserAuthentication(myid, null, null);
				
				String token = JwtTokenProvider.generateToken(auth, myid);
				System.out.println("token = "+token);
				
				map.put("token",token);
			} else {
				map.put("result", "nopass");
			}
		}
		return map;
	}
}
