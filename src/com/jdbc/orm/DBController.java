package com.jdbc.orm;

import java.sql.ResultSet;
import java.sql.SQLException;


public interface DBController {
	void createConnection(String connectivity, String url, String uName, String pass)throws ClassNotFoundException, SQLException;
	boolean create(String tblName)throws SQLException;
	ResultSet select(String columns, String tblName)throws SQLException;
	int insert(String sql)throws SQLException;
	int update(String name, int rollNo, String tblName)throws SQLException;
	int delete(int rollNo, String tblName)throws SQLException;
	void closeIt()throws SQLException;
}
