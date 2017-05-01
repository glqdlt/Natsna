package org.natsna.service;

import org.natsna.domain.UserVO;
import org.natsna.dto.LoginDTO;

public interface UserService {
	
	public UserVO login(LoginDTO dto) throws Exception;
	public void signInMemeber(UserVO vo) throws Exception;


}
