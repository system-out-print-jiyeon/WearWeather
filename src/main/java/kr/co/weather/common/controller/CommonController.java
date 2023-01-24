package main.java.kr.co.weather.common.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.kr.co.weather.common.Exception.UnExpectedInputException;
import main.java.kr.co.weather.user.model.User;
import main.java.kr.co.weather.user.service.UserService;


public class CommonController {
	
	public static void main(String[] args) {
		System.out.println("==================================================================");
		System.out.println("시작");
		System.out.println("==================================================================");
		
		User user = new User();
		List<String> genderList = new ArrayList<>();
		genderList.add("F");
		genderList.add("M");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 입력하세요");
		String id = sc.next();
		System.out.println("성별을 입력하세요 (M/F)");
		String gender = sc.next();
		
		if(!genderList.contains(gender.toUpperCase())) {
			throw new UnExpectedInputException();
		}
		
		
		if(id.equals("admin")) {
			System.out.println("관리자입니다.");
		}else {
			UserService userService = new UserService();
			System.out.println("유저입니다.");
			user.setUserId(id);
			user.setUserGender(gender);
			userService.storeUserInfo(user);
		}
	}
}
