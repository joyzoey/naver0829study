package mini.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	@Autowired
	private SqlSession session;
	private String nameSpace="mini.dao.MemberDao.";
	
	public int getTotalCount()
	{
		return session.selectOne(nameSpace+"totalCountOfMember");
	}
}
