package db.day2;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentDAO {
	ArrayList<StudentVO1> selectAllStudent() throws SQLException;
	
}
