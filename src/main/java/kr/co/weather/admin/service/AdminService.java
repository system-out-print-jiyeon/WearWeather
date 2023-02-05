package main.java.kr.co.weather.admin.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminService {

	public void goToAdminMenu() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("==========================");
		System.out.println("관리자 메뉴를 선택하세요. \n");
		System.out.println("1. 옷차림 데이터 관리");
		System.out.println("2. 사용자 조회");
		System.out.println("3. 사용자 등록");
		int menu = sc.nextInt();
		
		switch(menu) {
			case 1 : 
				this.managementClothesData();
				break;
			case 2 : 
				this.selectUser();
				break;
			case 3 : 
				this.insertUser();
				break;
			default : 
				System.out.println("💥💥💥올바른 메뉴를 입력해주세요! \n\n");
				this.goToAdminMenu();
				
		}
	}
	
	private void managementClothesData() {
		System.out.println("=======> 옷차림 데이터 관리");
	}
	
	private void selectUser() throws IOException {
		System.out.println("=======> 사용자  조회");
		try {
			File userFile = new File("C:\\storage\\User.txt"); 
			// 현재 등록된 사용자 읽어오기
	        FileReader filereader = new FileReader(userFile);
	        BufferedReader bufReader = new BufferedReader(filereader);
	        String line = "";
	        while((line = bufReader.readLine()) != null){
	            System.out.println(line);
	        }
	        bufReader.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	private void insertUser() throws IOException {
		System.out.println("=======> 사용자  등록");
		File userFile = new File("C:\\storage\\User.txt"); 
		List<String> currentUser = new ArrayList<>();
		
		userFile.createNewFile();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("등록하실 사용자 아이디를 입력하세요.");
		String userName = sc.next();
		
		// 현재 등록된 사용자 읽어오기
        FileReader filereader = new FileReader(userFile);
        BufferedReader bufReader = new BufferedReader(filereader);
        String line = "";
        while((line = bufReader.readLine()) != null){
            currentUser.add(line);
        }
        //.readLine()은 끝에 개행문자를 읽지 않는다.            
        bufReader.close();

        // 등록된 사용자 아닐경우에만 등록
        // append=true 기존값에 이어쓰기
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(userFile, true));
		if(!currentUser.contains(userName)) {
			if(userFile.isFile() && userFile.canWrite()){
	            bufferedWriter.write(userName);
	            bufferedWriter.newLine();
	            bufferedWriter.close();
	            System.out.println("[" + userName + "] 사용자 등록완료.");
	        }
		}else {
			System.out.println("이미 등록된 사용자입니다.");
			this.insertUser();
		}
		

		
	}

}
