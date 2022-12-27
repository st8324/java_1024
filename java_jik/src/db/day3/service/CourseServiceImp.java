package db.day3.service;

import java.util.Scanner;

import db.day3.DBConnector;
import db.day3.dao.*;
import db.day3.vo.CourseVO;
import db.day3.vo.LectureVO;

public class CourseServiceImp implements CourseService{

	private CourseMapper courseDao;
	private Scanner scan = new Scanner(System.in);
	
	public CourseServiceImp(DBConnector dbConnector) {
		courseDao = new CourseMapper(dbConnector);
	}

	public void insertLecture() {
		System.out.print("강좌명 : ");
		String le_name = scan.nextLine();
		System.out.print("일정 : ");
		String le_schedulre = scan.nextLine();
		System.out.print("학점 : ");
		int le_point = scan.nextInt();
		scan.nextLine();
		System.out.print("분반 : ");
		int le_class = scan.nextInt();
		scan.nextLine();
		System.out.print("연도 : ");
		int le_year = scan.nextInt();
		scan.nextLine();
		System.out.print("학기 : ");
		String le_term = scan.nextLine();
		System.out.print("지도교수번호 : ");
		String le_pr_num = scan.nextLine();
		LectureVO lecture = new LectureVO(0, le_name, le_schedulre, 
				le_point, le_class, le_year, le_term, le_pr_num);
		courseDao.insertLecture(lecture);
	}

	public void updateLecture() {
		System.out.print("강좌번호 : ");
		int le_num = scan.nextInt();
		scan.nextLine();
		System.out.print("강좌명 : ");
		String le_name = scan.nextLine();
		System.out.print("일정 : ");
		String le_schedulre = scan.nextLine();
		System.out.print("학점 : ");
		int le_point = scan.nextInt();
		scan.nextLine();
		System.out.print("분반 : ");
		int le_class = scan.nextInt();
		scan.nextLine();
		System.out.print("연도 : ");
		int le_year = scan.nextInt();
		scan.nextLine();
		System.out.print("학기 : ");
		String le_term = scan.nextLine();
		System.out.print("지도교수번호 : ");
		String le_pr_num = scan.nextLine();
		LectureVO lecture = new LectureVO(le_num, le_name, le_schedulre, 
				le_point, le_class, le_year, le_term, le_pr_num);
		courseDao.updateLecture(lecture);
	}

	public void deleteLecture() {
		System.out.print("강좌번호 : ");
		int le_num = scan.nextInt();
		scan.nextLine();
		courseDao.deleteLecture(le_num);
	}

	public void insertCourse() {
		System.out.print("강좌명(정확히 입력) : ");
		String le_name = scan.nextLine();
		System.out.print("분반 : ");
		int le_class = scan.nextInt();
		scan.nextLine();
		System.out.print("연도 : ");
		int le_year = scan.nextInt();
		scan.nextLine();
		System.out.print("학기(정확히 입력) : ");
		String le_term = scan.nextLine();
		System.out.print("학번 : ");
		String co_st_num = scan.nextLine();
		System.out.print("타입(학점,패스) : ");
		String co_type = scan.nextLine();
		LectureVO lec = courseDao.selectLectureByName(le_name, le_class, 
				le_year, le_term);
		if(lec == null) {
			System.out.println("수강 신청 실패");
			return;
		}
		courseDao.insertCourse(new CourseVO(0, co_st_num, lec.getLe_num(), co_type, null));
		
		
	}

	public void deleteCourse() {
		System.out.print("강좌명(정확히 입력) : ");
		String le_name = scan.nextLine();
		System.out.print("분반 : ");
		int le_class = scan.nextInt();
		scan.nextLine();
		System.out.print("연도 : ");
		int le_year = scan.nextInt();
		scan.nextLine();
		System.out.print("학기(정확히 입력) : ");
		String le_term = scan.nextLine();
		System.out.print("학번 : ");
		String co_st_num = scan.nextLine();
		System.out.print("타입(학점,패스) : ");
		String co_type = scan.nextLine();
		LectureVO lec = courseDao.selectLectureByName(le_name, le_class, 
				le_year, le_term);
		if(lec == null) {
			System.out.println("수강 취소 실패");
			return;
		}
		courseDao.deleteCourse(lec.getLe_num(), co_st_num);
		
	}
}
