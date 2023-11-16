package board.data;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //빈 자동 등록
public class AnswerDao {

	@Autowired //빈 자동 주입
	private SqlSession session;
	private String nameSpace="board.data.AnswerDao.";
	
	//댓글 추가 메서드
	public void insertAnswer(AnswerDto dto)
	{
		session.insert(nameSpace+"insertAnswer",dto);
	}
	//댓글 불러오기 메서드
	public List<AnswerDto> getAnswers(int num)
	{
		return session.selectList(nameSpace+"selectAnswerByNum", num);
	}
	//댓글 삭제 메서드
	public void deleteAnswer(int idx)
	{
		session.delete(nameSpace+"deleteAnswer",idx);
	}
}
