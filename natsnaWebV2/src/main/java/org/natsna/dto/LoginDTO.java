package org.natsna.dto;

/**
 * user/login 에서 넘어오는 로그인용 데이터
 * useRemember 는 쿠키기능인데, 지금은 개발 하지 않는다.
 * @author glqdl
 *
 */
public class LoginDTO {

	private String userid;
	private String userpw;
	private boolean useRemember;
	

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}


	public boolean isUseRemember() {
		return useRemember;
	}

	public void setUseRemember(boolean useRemember) {
		this.useRemember = useRemember;
	}

}
