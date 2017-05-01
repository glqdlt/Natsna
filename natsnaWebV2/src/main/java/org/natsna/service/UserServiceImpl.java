package org.natsna.service;

import javax.inject.Inject;

import org.natsna.domain.UserVO;
import org.natsna.dto.LoginDTO;
import org.natsna.persistence.UserDAO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	UserDAO dao;

	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return dao.login(dto);
	}

	@Override
	public void signInMemeber(UserVO vo) throws Exception {
		dao.signInMemeber(vo);

	}

}
