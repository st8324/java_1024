package db.day3.dao;

import db.day3.DBConnector;

public class StudentMapper implements StudentDAO {

	private DBConnector dbConnector;
	
	public StudentMapper(DBConnector dbConnector) {
		this.dbConnector = dbConnector;
	}

}
