package main.java.kr.co.weather.user.service;

import main.java.kr.co.weather.user.model.User;

public class UserService {
	
	public void storeUserInfo(User user) {
		String gender = user.getUserGender();
		System.out.println("아이디 : " + user.getUserId());
		if(gender.toUpperCase().equals("F")) {
			System.out.println("성별 : 여자");
		}else {
			System.out.println("성별 : 남자");
		}
		//return user;
	}

}
