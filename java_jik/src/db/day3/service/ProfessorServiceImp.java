package db.day3.service;

import java.util.Scanner;

import db.day3.DBConnector;
import db.day3.dao.ProfessorMapper;
import db.day3.vo.ProfessorVO;
import db.day3.vo.StudentVO;

public class ProfessorServiceImp implements ProfessorService {

	private ProfessorMapper professorDao;
	private Scanner scan = new Scanner(System.in);
	
	public ProfessorServiceImp(DBConnector dbConnector) {
		professorDao = new ProfessorMapper(dbConnector);
	}

	public void insertProfessor() {
		System.out.println("추가할 교수 정보 입력하세요.");
		System.out.print("교번 : ");
		String pr_num = scan.nextLine();
		System.out.print("이름 : ");
		String pr_name = scan.nextLine();
		System.out.print("상태 : ");
		String pr_state = scan.nextLine();
		System.out.print("학부번호 : ");
		String pr_de_num = scan.nextLine();
		System.out.print("전화번호 : ");
		String pr_tell = scan.nextLine();
		ProfessorVO professorVO = new ProfessorVO(pr_num, pr_name, 
				pr_state, pr_de_num, pr_tell); 
		professorDao.insertProfessor(professorVO);
	}

	public void updateProfessor() {
		System.out.println("수정할 교수 정보 입력하세요.");
		System.out.print("교번 : ");
		String pr_num = scan.nextLine();
		System.out.print("이름 : ");
		String pr_name = scan.nextLine();
		System.out.print("상태 : ");
		String pr_state = scan.nextLine();
		System.out.print("학부번호 : ");
		String pr_de_num = scan.nextLine();
		System.out.print("전화번호 : ");
		String pr_tell = scan.nextLine();
		ProfessorVO professorVO = new ProfessorVO(pr_num, pr_name, 
				pr_state, pr_de_num, pr_tell); 
		professorDao.updateProfessor(professorVO);
		
	}
}
