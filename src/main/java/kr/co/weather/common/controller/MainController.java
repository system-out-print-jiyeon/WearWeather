package main.java.kr.co.weather.common.controller;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import main.java.kr.co.weather.admin.service.AdminService;
import main.java.kr.co.weather.common.model.Weather;
import main.java.kr.co.weather.common.service.MainService;
import main.java.kr.co.weather.user.model.User;
import main.java.kr.co.weather.user.service.UserService;


public class MainController {
	
	
	public static void main(String[] args) throws ParseException, IOException {		
		MainService mainService = new MainService();
		UserService userService = new UserService();
		AdminService adminService = new AdminService();
		
		System.out.println("==================================================================");
		System.out.println("===================== ⛅ Wear Weather ⛅  =========================");
		System.out.println("==================================================================");

		// 날씨 api연결
		Weather weather = mainService.getWeatherInfo();
		// 유저 정보 입력, 저장
		User user = userService.storeUserInfo();
		
		if("Y".equalsIgnoreCase(user.getAdminYn())) {
			adminService.goToAdminMenu();
		}
		
		
	}
}
