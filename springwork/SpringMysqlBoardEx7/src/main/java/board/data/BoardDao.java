package board.data;

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
	
	public void insertBoard(BoardDto dto)
	{
		session.insert(nameSpace+"insertBoard",dto);
	}
}
