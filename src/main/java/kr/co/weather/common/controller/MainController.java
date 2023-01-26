package main.java.kr.co.weather.common.controller;

import org.json.simple.parser.ParseException;

import main.java.kr.co.weather.common.service.MainService;
import main.java.kr.co.weather.user.service.UserService;


public class MainController {
	
	
	public static void main(String[] args) throws ParseException {		
		MainService mainService = new MainService();
		UserService userService = new UserService();
		
		System.out.println("==================================================================");
		System.out.println("===================== ⛅ Wear Weather ⛅  =========================");
		System.out.println("==================================================================");

		mainService.getWeatherInfo();
		userService.storeUserInfo();
		
	}
}
