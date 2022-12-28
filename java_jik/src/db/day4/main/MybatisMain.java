package db.day4.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.day4.dao.StudentDAO;
import db.day4.vo.CourseVO;
import db.day4.vo.StudentVO;

public class MybatisMain {

	public static void main(String[] args) {
		String resource = "db/day4/main/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			try (SqlSession session = sqlSessionFactory.openSession()) {
				StudentDAO studentDao = session.getMapper(StudentDAO.class);
				ArrayList<StudentVO> list = studentDao.selectAllStudent();
				System.out.println(list);
				//StudentVO std = new StudentVO("2022123003","홍기계3",2,"재학","2022160001");
				//studentDao.insertStudent(std);
				CourseVO co = new CourseVO("2022123001",1,"학점");
				//sysout(co.getCo_num());
				studentDao.insertCourse(co);
				System.out.println(co);
				session.commit();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
}
