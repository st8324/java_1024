package example.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Main {


	
	
	public static void main(String[] args) throws IOException {
		String resource = "example/test/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		try (SqlSession session = sqlSessionFactory.openSession()) {
		  StudentDAO studentDao = session.getMapper(StudentDAO.class);
		  List<StudentVO> list = studentDao.selectAllStudent();
		  System.out.println(list);
		}
	}

}
