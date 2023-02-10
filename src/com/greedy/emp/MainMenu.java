package com.greedy.emp;

import java.util.Scanner;

public class MainMenu {

	public void displayMenu() {
		
		Scanner sc = new Scanner(System.in);
		EmployeeDAO empDAO = new EmployeeDAO();
		
		do {
		
			
		System.out.println("============== 직원 정보 조회 프로그램 =============");
		System.out.println("1. 사원 번호로 직원 정보 조회");
		System.out.println("2. 전체 직원 정보 조회");
		System.out.println("3. 성별로 직원 정보 조회");
		System.out.println("4. 급여순 오름차순 정렬 조회");
		System.out.println("5. 급여순 내림차순 정렬 조회");
		System.out.println("6. 입사일 순 오름차순 조회");
		System.out.println("7. 입사일 순 내림차순 조회");
		System.out.println("8. 급여 상위 5명 조회");
		System.out.println("9. 급여 상위 6위 ~ 10위 조회");
		System.out.println("0. 프로그램 종료");
		System.out.println("=============================================");
		System.out.print("메뉴 번호 입력 : ");
		int no = sc.nextInt();
		
		switch(no) {
		case 1 : empDAO.findOneEmpByEmpId(inputEmpId()); break;
		case 2 : break;
		case 3 : break;
		case 4 : break;
		case 5 : break;
		case 6 : break;
		case 7 : break;
		case 8 : break;
		case 9 : break;
		case 0 : System.out.println("프로그램을 종료합니다."); return;
			
		}
		
		} while(true);
		
	}
		private String inputEmpId() {
			
			Scanner sc = new Scanner(System.in);
			System.out.print("조회할 사번을 입력하세요 : ");
			String empId = sc.nextLine();
			
			return empId;
	}
}
