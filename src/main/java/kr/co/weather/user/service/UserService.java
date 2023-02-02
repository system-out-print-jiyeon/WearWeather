package main.java.kr.co.weather.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.kr.co.weather.common.Exception.UnExpectedInputException;
import main.java.kr.co.weather.user.model.User;

public class UserService {
	
	public User storeUserInfo() {
		User user = new User();
		String gender = "";
		List<String> genderList = new ArrayList<>();
		genderList.add("F");
		genderList.add("M");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("\n아이디를 입력하세요 : ");
		String id = sc.next();
		user.setUserId(id);
		
		if("admin".equals(id)) {
			System.out.println("\n-------- 관리자입니다. --------");
			user.setAdminYn("Y");
		}else {
			System.out.println("\n-------- 유저입니다. --------");
			user.setAdminYn("N");
			System.out.print("성별을 입력하세요 (M/F) : ");
			gender = sc.next();
			user.setUserGender(gender);
			
			if(!genderList.contains(gender.toUpperCase())) {
				throw new UnExpectedInputException();
			}

			System.out.println("아이디 : " + id);
			if("F".equals(gender.toUpperCase())) {
				System.out.println("성별 : 여자");
			}else {
				System.out.println("성별 : 남자");
			}
		}
		
		return user;
	}

}
