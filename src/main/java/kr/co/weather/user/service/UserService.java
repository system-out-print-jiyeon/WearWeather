package main.java.kr.co.weather.user.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import main.java.kr.co.weather.common.Enum.Clothes;
import main.java.kr.co.weather.common.Exception.UnExpectedInputException;
import main.java.kr.co.weather.common.model.Weather;
import main.java.kr.co.weather.common.service.MainService;
import main.java.kr.co.weather.user.model.User;

public class UserService {
	
	MainService mainService = new MainService();
	
	public User userLogin() {
		User user = new User();
		List<String> userList = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.print("\n아이디를 입력하세요 : ");
		String id = sc.next();
		user.setUserId(id);
		
		if("admin".equals(id)) {
			System.out.println("\n-------- 관리자입니다. --------");
			user.setAdminYn("Y");
		}else {
			
			try {
				File userFile = new File("C:\\storage\\UserId.txt"); 
				// 현재 등록된 사용자 읽어오기
		        FileReader filereader = new FileReader(userFile);
		        BufferedReader bufReader = new BufferedReader(filereader);
		        String line = "";
		        while((line = bufReader.readLine()) != null){
		        	userList.add(line);
		        }
		        bufReader.close();
			} catch (Exception e) {
				System.out.println(e);
			}
			
			if(userList.contains(id)) {
				System.out.println("\n-------- 유저입니다. --------");
				user.setAdminYn("N");
				this.goToUserMenu(user.getUserId());
			}else {
				System.out.println("\n-------- 등록된 유저가 아닙니다. 관리자에게 등록요청하세요. --------");
			}			
		}
		return user;
	}
	
	public void goToUserMenu(String userId) {
		// 유저정보 가져와서 set
		User user = this.getUser(userId);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("==========================");
		System.out.println("메뉴를 선택하세요. \n");
		System.out.println("1. 옷차림 추천받기");
		System.out.println("2. 현재 날씨 조회");
		System.out.println("3. 마이페이지");
		int menu = sc.nextInt();
		
		switch(menu) {
			case 1 : 
				this.getTodayOutfit(user);
				break;
			case 2 : 
				mainService.printWeather(user);
				break;
			case 3 : 
				this.goToMyPage(userId);
				break;
			default : 
				System.out.println("💥💥💥올바른 메뉴를 입력해주세요! \n\n");
				this.goToUserMenu(userId);
				
		}
	}
	
	public void getTodayOutfit(User user) {
		System.out.println("=======> 옷차림 추천받기");
		Weather weather = mainService.getWeatherInfo(user);
		String clothesRecommend =  Clothes.getTemperature(weather.getFeelsLike());
		
		System.out.println("[ 현재 " + weather.getLocation() + "의 체감온도 : " + weather.getFeelsLike() + " ]");
		System.out.println(clothesRecommend);
	}
	
	public void goToMyPage(String userId) {
		System.out.println("=======> 마이페이지");
		Scanner sc = new Scanner(System.in);
		System.out.println("==========================");
		System.out.println("1. 내 정보 조회");
		System.out.println("2. 내 정보 수정");
		int menu = sc.nextInt();
		switch(menu) {
			case 1 : 
				this.getMyInfo(userId);
				break;
			case 2 : 
				this.updateMyInfo(userId);
				break;
			default : 
				System.out.println("💥💥💥올바른 메뉴를 입력해주세요! \n\n");
				this.goToMyPage(userId);
		}
	}
	
	private void getMyInfo(String userId) {
		System.out.println("=======> 내 정보 조회");
		getUser(userId);
	}
	
	private void updateMyInfo(String userId) {
		System.out.println("=======> 내 정보 수정");
		String fileName = "C:\\storage\\users\\" + userId + ".txt";
		List<String> genderList = new ArrayList<>();
		genderList.add("F");
		genderList.add("M");
		
		// 파일 내용 지우기
        try (BufferedWriter bf = Files.newBufferedWriter(Paths.get(fileName),
                StandardOpenOption.TRUNCATE_EXISTING)) {
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 수정할 정보 입력받아 json형식으로 파일 내용 입력
		Scanner sc = new Scanner(System.in);
		System.out.println("========= 수정할 정보 입력 =========");
		System.out.println("이름을 입력하세요.");
		String name = sc.next();
		System.out.println("지역을 입력하세요.");
		String location = sc.next();
		System.out.println("성별을 입력하세요.(M/F)");
		String gender = sc.next();
		if(!genderList.contains(gender.toUpperCase())) {
			throw new UnExpectedInputException();
		}
		
        File userFile = new File("C:\\storage\\users\\" + userId + ".txt"); 
		BufferedWriter bufferedWriter;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(userFile, true));
	        if(userFile.isFile() && userFile.canWrite()){
	            bufferedWriter.write(
	            		"{\"userId\":\"" + userId
	            		+ "\",\"userName\":\"" + name
	            		+ "\",\"userLocation\":\"" + location
	            		+ "\",\"userGender\":\"" + gender 
	            		+ "\"}");
	            bufferedWriter.close();
	            System.out.println("[" + userId + "] 사용자 정보 수정완료.");
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private User getUser(String userId) {
		User user = new User();
		// 유저정보 가져와서 set
		try {
			File userFile = new File("C:\\storage\\users\\" + userId + ".txt"); 
			FileReader filereader = new FileReader(userFile);
	        BufferedReader bufReader = new BufferedReader(filereader);
	        String line = "";
	        while((line = bufReader.readLine()) != null){
	        	JSONParser parser = new JSONParser();
				Object obj = parser.parse(line);
				JSONObject jsonObj = (JSONObject) obj;
				user.setUserId(userId);
				user.setUserName((String) jsonObj.get("userName"));
				user.setUserLocation((String) jsonObj.get("userLocation"));
				user.setUserGender((String) jsonObj.get("userGender"));
		        System.out.println(line);
	        }
	        bufReader.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return user;
	}

}
