package board.data;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //bean�� �ڵ�������ִ� ������̼�:dao�� �ַ� ���δ�
public class BoardDao {
	
	@Autowired //�ڵ�����(root.xml���Ͽ���)
	private SqlSession session;
	
	private String nameSpace="board.data.BoardDao.";
	
	//��ü ���� ��ȯ�ϴ� �޼���
	public int getTotalCount()
	{
		return session.selectOne(nameSpace+"totalCountOfBoard");
	}
	
	public void insertBoard(BoardDto dto)
	{
		session.insert(nameSpace+"insertBoard",dto);
	}
}