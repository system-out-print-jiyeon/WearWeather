package main.java.kr.co.weather.admin.service;

import java.util.Scanner;

public class AdminService {

	public void goToAdminMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("==========================");
		System.out.println("관리자 메뉴를 선택하세요. \n");
		System.out.println("1. 옷차림 데이터 관리");
		System.out.println("2. 사용자 관리");
		System.out.println("3. ...");
		int menu = sc.nextInt();
		
		switch(menu) {
			case 1 : 
				this.managementClothesData();
				break;
			case 2 : 
				this.managementUser();
				break;
			default : 
				System.out.println("💥💥💥올바른 메뉴를 입력해주세요! \n\n");
				this.goToAdminMenu();
				
		}
	}
	
	private void managementClothesData() {
		System.out.println("=======> 옷차림 데이터 관리");
	}
	
	private void managementUser() {
		System.out.println("=======> 사용자  관리");
	}

}
