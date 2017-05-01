package org.natsna.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.natsna.domain.UserVO;
import org.natsna.dto.LoginDTO;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	@Inject
	private SqlSession sql;

	private static String namespace = "org.natsna.mapper.UserMapper";

	@Override
	public UserVO login(LoginDTO dto) throws Exception {

		return sql.selectOne(namespace + ".login", dto);
	}

	@Override
	public void signInMemeber(UserVO vo) throws Exception {
		sql.insert(namespace + ".signInMemeber", vo);

	}

}
