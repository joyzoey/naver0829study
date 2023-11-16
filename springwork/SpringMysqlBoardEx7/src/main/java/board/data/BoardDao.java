package board.data;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //bean을 자동등록해주는 어노테이션:dao에 주로 붙인다
public class BoardDao {
	
	@Autowired //자동주입(root.xml파일에서)
	private SqlSession session;
	private String nameSpace="board.data.BoardDao.";
	
	//전체 갯수 반환하는 메서드
	public int getTotalCount()
	{
		return session.selectOne(nameSpace+"totalCountOfBoard");
	}
	//글쓰기 메서드
	public void insertBoard(BoardDto dto)
	{
		session.insert(nameSpace+"insertBoard",dto);
	}
	//리스트반환 메서드
	public List<BoardDto> getAllDatas()
	{
		return session.selectList(nameSpace+"selectAllBoard");
	}
	//조회수증가 메서드
	public void updateReadcount(int num)
	{
		session.update(nameSpace+"updateReadcount", num);
	}
	//글내용 반환 메서드
	public BoardDto getData(int num)
	{
		return session.selectOne(nameSpace+"selectOneData", num);
	}
	//글삭제 메서드
	public void deleteBoard(int num)
	{
		session.delete(nameSpace+"deleteBoard", num);
	}
	//글수정 메서드
	public void updateBoard(BoardDto dto)
	{
		session.update(nameSpace+"updateBoard", dto);
	}
}
