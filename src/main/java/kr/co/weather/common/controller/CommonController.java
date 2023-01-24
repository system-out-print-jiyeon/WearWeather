package main.java.kr.co.weather.common.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import main.java.kr.co.weather.common.Exception.UnExpectedInputException;
import main.java.kr.co.weather.user.model.User;
import main.java.kr.co.weather.user.service.UserService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class CommonController {
	
	private static final String API_KEY = "98cbd528c3567d033b5add1992086892";
	
	public static void main(String[] args) throws ParseException {

		User user = new User();
		List<String> genderList = new ArrayList<>();
		genderList.add("F");
		genderList.add("M");
		
		System.out.println("==================================================================");
		System.out.println("====================== ⛅ Wear Weather ⛅  ==========================");
		System.out.println("==================================================================");

		Scanner sc = new Scanner(System.in);
		System.out.print("지역을 입력하세요 : ");
		String location = sc.next();
		
		try {
			URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + location + ",KR&APPID=" + API_KEY + "&units=metric");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output;
			System.out.println("\n[현재 날씨]");
			while ((output = br.readLine()) != null) {
				
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(output);
				JSONObject jsonObj = (JSONObject) obj;
				JSONObject weatherObj = (JSONObject) ((JSONArray) jsonObj.get("weather")).get(0);
				JSONObject temperObj = (JSONObject) jsonObj.get("main");
				
				
				
				System.out.println("지역 : " + jsonObj.get("name"));
				System.out.println("날씨 : " + weatherObj.get("description"));
				System.out.println("기온 : " + temperObj.get("temp_min"));
			}

			conn.disconnect();

		  } catch (MalformedURLException e) { // TODO : exception 처리
			e.printStackTrace(); 
		  } catch (IOException e) {
			e.printStackTrace();
		  }
		
		System.out.print("\n아이디를 입력하세요 : ");
		String id = sc.next();
		System.out.print("성별을 입력하세요 (M/F) : ");
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
