package data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import data.dto.MemberDto;
import data.mapper.MemberMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberService {
	private MemberMapper memberMapper;
	
	//총갯수
	public int getTotalCount()
	{
		return memberMapper.getTotalCount();
	}
	
	//리스트
	public List<MemberDto> getAllMembers()
	{
		return memberMapper.getAllMembers();
	}
	
	//추가
	public void insertMember(MemberDto dto)
	{
		memberMapper.insertMember(dto);
	}
	
	//id 체크
	public int getIdCheck(String myid)
	{
		return memberMapper.getIdCheck(myid);
	}
	
	//삭제
	public void deleteMember(int num) {
		memberMapper.deleteMember(num);
	}

	//디테일
	public MemberDto getMember(int num)
	{
		return memberMapper.getMember(num);
	}
	
	//로그인
	public MemberDto getLogin(String myid)
	{
		return memberMapper.getLogin(myid);
	}
}
