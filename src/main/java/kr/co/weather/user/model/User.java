package main.java.kr.co.weather.user.model;

public class User {

	public User() {}
	
	/** 사용자 아이디. */
	private String userId;

	/** 사용자 성별. */
	private String userGender;


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserGender() {
		return userGender;
	}


	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	
}