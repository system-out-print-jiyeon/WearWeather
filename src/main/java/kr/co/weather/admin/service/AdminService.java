package main.java.kr.co.weather.admin.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

	}
	
	private void insertUser() throws IOException {
		System.out.println("=======> 사용자  등록");
		File userFile = new File("C:\\storage\\User.txt"); 
		userFile.createNewFile();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("등록하실 사용자 아이디를 입력하세요.");
		String userName = sc.next();
		
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(userFile));
		
		if(userFile.isFile() && userFile.canWrite()){
            //쓰기
            bufferedWriter.write(userName);
            //개행문자쓰기
            bufferedWriter.newLine();
            
            bufferedWriter.close();
        }
		

		
	}

}
