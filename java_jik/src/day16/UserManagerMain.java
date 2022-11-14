package day16;

import java.util.ArrayList;
import java.util.Scanner;

public class UserManagerMain {

	public static void main(String[] args) {
		/* 회원 정보를 관리하는 프로그램을 작성하세요.
		 * - 회원 정보는 아이디, 비번, 이름, 나이, 주민번호로 구성
		 * - 기능1 : 회원 추가
		 * - 기능2 : 회원 검색
		 * - 기능3 : 회원 정보 수정
		 * - 기능4 : 회원 삭제
		 * */
		//반복
		int menu = -1;
		Scanner scan = new Scanner(System.in);
		ArrayList<Member1> list = new ArrayList<Member1>();//회원 리스트
		do {
			//메뉴 출력
			printMenu();
			//메뉴를 선택(입력)
			menu = scan.nextInt();
			//선택된 메뉴에 따른 기능 실행
			switch(menu) {
			case 1:	
				if(addMember(list)) {
					printStr("입력한 회원 정보를 추가했습니다.");
				}else {
					printStr("입력한 아이디가 이미 존재합니다.");
				}
				break;
			case 2:	
				if(!search(list)) {
					printStr("아이디 또는 비밀번호가 잘못됐습니다.");
				}
				break;
			case 3:	
				break;
			case 4:	
				break;
			case 5:
				System.out.println("프로그램 종료");
				break;
			default:
				System.out.println("잘못된 메뉴");//예외 처리 예정
			}
		}while(menu != 5);
	}
	
	public static void printMenu() {
		System.out.println("------메뉴------");
		System.out.println("1. 회원 추가");
		System.out.println("2. 회원 검색");
		System.out.println("3. 회원 정보 수정");
		System.out.println("4. 회원 삭제");
		System.out.println("5. 종료");
		System.out.println("---------------");
		System.out.print("메뉴 선택 : ");
	}
	
	public static boolean addMember(ArrayList<Member1> list) {
		Scanner scan = new Scanner(System.in);
		//회원 정보 입력
		//아이디, 비번, 이름, 주민번호, 나이 순으로
		System.out.println("회원 정보를 입력하세요.");
		System.out.print("아이디 : ");
		String id = scan.next();
		System.out.print("비번 : ");
		String pw = scan.next();
		System.out.print("이름 : ");
		String name = scan.next();
		System.out.print("주민번호 : ");
		String residentNumber = scan.next();
		System.out.print("나이 : ");
		int age = scan.nextInt();
		
		//입력한 정보를 이용한 객체를 생성(회원 리스트에 비교 및 추가)
		Member1 member = new Member1(id, pw, name, residentNumber, age);
		
		//회원 리스트에 이미 가입된 아이디이면 안내문구 출력 후 종료
		//회원 아이디가 같은 회원이 있으면
		if(list.contains(member)) {
			//건너뜀
			return false;
		}
		//아니면 회원 리스트에 member 객체를 추가
		list.add(member);
		return true;
	}
	public static void printStr(String str) {
		System.out.println("---------------");
		System.out.println(str);
		System.out.println("---------------");
	}
	public static boolean search(ArrayList<Member1> list) {
		Scanner scan = new Scanner(System.in);
		//아이디 입력
		System.out.println("검색할 회원 정보를 입력하세요.");
		System.out.print("아이디 : ");
		String id = scan.next();

		//비번 입력
		System.out.print("비번 : ");
		String pw = scan.next();
		
		//아이디, 비번을 이용하여 객체를 만듬
		Member1 member = new Member1(id, pw);
		
		//회원 리스트에서 아이디가 같은 회원 정보를 가져옴
		int index = list.indexOf(member);
		if(index == -1) {
			return false;
		}
		Member1 tmp = list.get(index);
		
		//가져온 회원 정보의 비번과 입력한 비번을 비교하여 다르면 종료
		if(!tmp.getPw().equals(member.getPw())) {
			return false;
		}
		//같으면 회원정보를 보여줌
		System.out.println(tmp);
		return true;
	}
}



