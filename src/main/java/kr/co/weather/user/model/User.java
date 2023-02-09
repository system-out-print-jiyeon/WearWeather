package main.java.kr.co.weather.user.model;

public class User {

	public User() {}
	
	/** 사용자 아이디. */
	private String userId;
	
	/** 사용자 설정지역 */
	private String userLocation;

	/** 사용자 성별. */
	private String userGender;

	/** 관리자 여부 */
	private String adminYn;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserLocation() {
		return userLocation;
	}

	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}

	public String getUserGender() {
		return userGender;
	}


	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getAdminYn() {
		return adminYn;
	}

	public void setAdminYn(String adminYn) {
		this.adminYn = adminYn;
	}
	
}
