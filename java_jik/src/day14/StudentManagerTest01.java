package day14;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagerTest01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Student> stds = new ArrayList<Student>();
		
		int menu = -1;
		for( ;menu != 4 ; ) {

			printMenu();
			
			menu = scan.nextInt();
			
			runMenu(menu, stds);
		}//for문 끝
	}//main 끝

	private static void runMenu(int menu, ArrayList<Student> stds) {
		Scanner scan = new Scanner(System.in);
		switch(menu) {
		case 1:
			if(addStudent(stds)) {
				System.out.println("학생을 추가했습니다.");
			}else {
				System.out.println("학생을 추가하지 못했습니다.");
			}
			break;
		case 2:
			if(addScore(stds)) {
				System.out.println("성적을 등록했습니다.");
			}else {
				System.out.println("성적을 등록하지 못했습니다.");
			}
			break;
		case 3:	
			printStudentList(stds);
			break;
		case 4: 
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("잘못된 메뉴!!");
		}
	}

	private static void printStudentList(ArrayList<Student> stds) {
		for(Student tmp : stds) {
			System.out.println(tmp);
			tmp.printScore();
		}
	}

	private static boolean addScore(ArrayList<Student> stds) {
		System.out.println("성적을 추가할 학생 정보 입력");
		Student tmp = scanStudentBaseInfo();
		int index = stds.indexOf(tmp);
		
		if(index == -1) {
			return false;
		}
		
		System.out.println("성적 정보를 입력하세요.");
		return stds.get(index).addScore(scanScore());
	}

	private static boolean addStudent(ArrayList<Student> stds) {
		Scanner scan = new Scanner(System.in);
		System.out.println("추가할 학생 정보 입력");
		Student tmp = scanStudentBaseInfo();
		
		System.out.print("이름 : ");
		tmp.setName(scan.next());
		
		int index = stds.indexOf(tmp);
		
		if(index == -1) {
			stds.add(tmp);
			return true;
		}
		return false;
	}

	private static Score scanScore() {
		Scanner scan = new Scanner(System.in);
		System.out.print("과목 : ");
		String title = scan.next();
		System.out.print("학기 : ");
		int term = scan.nextInt();
		System.out.print("중간 : ");
		int midScore = scan.nextInt();
		System.out.print("기말 : ");
		int finalScore = scan.nextInt();
		System.out.print("수행평가 : ");
		int performace = scan.nextInt();
		return new Score(title, term, midScore, finalScore, performace);
	}

	private static Student scanStudentBaseInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반  : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		return new Student(grade, classNum, num);
	}

	private static void printMenu() {
		System.out.println("------메뉴-----");
		System.out.println("1. 학생 정보 추가");
		System.out.println("2. 학생 성적 추가");
		System.out.println("3. 학생 정보 출력");
		System.out.println("4. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
}
