package org.natsna.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.natsna.domain.MemberVO;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "org.natsna.mapper.MemberMapper";

	@Override
	public String getTime() {
		return sqlSession.selectOne(namespace + ".getTime");
	}

	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert(namespace + ".insertMember", vo);

	}

	@Override
	public MemberVO readMember(String userid) throws Exception {
		return sqlSession.selectOne(namespace + ".selectMember", userid);
	}

	@Override
	public MemberVO readWithPW(String userid, String userpw) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("userid", userid);
		map.put("userpw", userpw);

		return sqlSession.selectOne(namespace + ".readWithPW", map);
	}
	
	

}
