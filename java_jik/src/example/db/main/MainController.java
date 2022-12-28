package example.db.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import example.db.dao.StudentDAO;
import example.db.vo.StudentVO;
import example.db.vo.StudentVO2;


public class MainController {

	private SqlSession session;
	private StudentDAO studentDao;
	private Scanner scan;
	
	public MainController(SqlSession session) {
		this.session = session;
		studentDao = session.getMapper(StudentDAO.class);
		scan = new Scanner(System.in);
	}

	public void run() {
		/* 학생 추가
		 * 학생 수정
		 * 학생 조회
		 * 프로그램 종료 
		 * */
		int menu = -1;
		int exit = 4;
		do {
			try {
				printMenu();
				menu = scan.nextInt();
				scan.nextLine();
				runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 타입을 입력");
				scan.nextLine();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}while(menu != exit);
		System.out.println("프로그램 종료");
	}

	private void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertStudent();
			break;
		case 2:
			updateStudent();
			break;
		case 3:
			selectAllStudent();
			break;
		case 4:	break;
		default:
			System.out.println("잘못된 메뉴 선택");
		}
	}

	private void selectAllStudent() {
		//ArrayList<StudentVO> list = studentDao.selectAllStudent();
		ArrayList<StudentVO2> list = studentDao.selectAllStudent2();
		if(list.size() == 0) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		/*
		for(StudentVO tmp : list) {
			System.out.println(tmp);
		}*/
		for(StudentVO2 tmp : list) {
			System.out.println(tmp);
		}
		
	}

	private void updateStudent() {
		System.out.println("학생 정보 입력");
		System.out.print("학번 : ");
		String st_num = scan.nextLine();
		System.out.print("학기 : ");
		int st_semester = scan.nextInt();
		scan.nextLine();
		System.out.print("상태(재학/휴학/자퇴/퇴학/졸업/수료) : ");
		String st_state = scan.nextLine();

		StudentVO std = studentDao.selectStudent(st_num);
		
		if(std == null) {
			System.out.println("학생 수정 실패");
			return;
		}
		std.setSt_semester(st_semester);
		std.setSt_state(st_state);
		
		if(studentDao.updateStudent(std) != 0) {
			System.out.println("학생 수정 성공");
			session.commit();
		}else {
			System.out.println("학생 수정 실패");
		}
		
	}

	private void insertStudent() {
		System.out.println("학생 정보 입력");
		System.out.print("학번 : ");
		String st_num = scan.nextLine();
		System.out.print("이름 : ");
		String st_name = scan.nextLine();
		System.out.print("학기 : ");
		int st_semester = scan.nextInt();
		scan.nextLine();
		System.out.print("상태(재학/휴학/자퇴/퇴학/졸업/수료) : ");
		String st_state = scan.nextLine();
		System.out.print("지도교수 번호 : ");
		String st_pr_num = scan.nextLine();
		StudentVO std = new StudentVO(st_num, st_name, 
				st_semester, st_state, st_pr_num);
		if(studentDao.insertStudent(std) != 0) {
			System.out.println("학생 추가 성공");
			session.commit();
		}else {
			System.out.println("학생 추가 실패");
		}
	}

	private void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 조회");
		System.out.println("4. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}

}
