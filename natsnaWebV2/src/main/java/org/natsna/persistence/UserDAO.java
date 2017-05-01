package org.natsna.persistence;

import org.natsna.domain.UserVO;
import org.natsna.dto.LoginDTO;

public interface UserDAO {
	
	public UserVO login(LoginDTO dto) throws Exception;
	public void signInMemeber(UserVO vo) throws Exception;

}
