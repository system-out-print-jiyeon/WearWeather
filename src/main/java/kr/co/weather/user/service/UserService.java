package main.java.kr.co.weather.user.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.kr.co.weather.user.model.User;

public class UserService {
	
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
			}else {
				System.out.println("\n-------- 등록된 유저가 아닙니다. 관리자에게 등록요청하세요. --------");
			}			
		}
		return user;
	}
	
	

}
