package mini.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mini.dto.GuestDto;

@Repository
public class GuestDao {
	@Autowired
	private SqlSession session;
	private String nameSpace="mini.dao.GuestDao.";
	
	//추가
	public void insertGuest(GuestDto dto)
	{
		session.insert(nameSpace+"insertGuest",dto);
	}
	//전체리스트
	public List<GuestDto> getAllGuest()
	{
		return session.selectList(nameSpace+"selectAllGuest");
	}
	//삭제
	public void deleteGuest(int guest_num)
	{
		session.delete(nameSpace+"deleteGuest", guest_num);
	}
	
}
