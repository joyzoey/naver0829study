package mini.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mini.dto.BoardDto;

@Repository
public class BoardDao {
	@Autowired
	private SqlSession session;
	private String nameSpace="mini.dao.BoardDao.";
	
	//총 개시글의 개수
	public int getTotalCount()
	{
		return session.selectOne(nameSpace+"totalCountOfBoard");
	}
	//게시글 리스트
	public List<BoardDto> getList(Map<String,Integer> map)
	{
		return session.selectList(nameSpace+"selectPagingOfBoard", map);
	}
	
	public int getMaxNum()
	{
		return session.selectOne(nameSpace+"selectMaxNumOfBoard");		
	}
	//순서변수 수정(계층형게시판)
	public void updateRestep(Map<String,Integer> map)
	{
		session.update(nameSpace+"updateRestepOfBoard",map);
	}
	//추가
	public void insertBoard(BoardDto dto)
	{
		session.insert(nameSpace+"insertBoard",dto);
	}
	//조회수수정
	public void updateReadCount(int num)
	{
		session.update(nameSpace+"updateReadCountOfBoard",num);
	}
	//게시글 내용
	public BoardDto getData(int num)
	{
		return session.selectOne(nameSpace+"selectDataByNum",num);
	}
	//수정
	public void updateBoard(BoardDto dto)
	{
		session.update(nameSpace+"updateBoard", dto);
	}
	//삭제
	public void deleteBoard(int num)
	{
		session.delete(nameSpace+"deleteBoard", num);
	}
}
