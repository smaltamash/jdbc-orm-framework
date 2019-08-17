package com.jdbc.orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JdbcOrmFramework implements DBController {
	public String connectivity="";
	public String url="";
	public String userName="";
	public String pass="";
	public Connection conn;
	public Statement stmt;
	public ResultSet rs;
	public void save(Student s, String tblName)throws SQLException {
		int i=insert("insert into "+tblName+" values('"+s.getStudentName()+"', "+s.getRollNo()+", "+s.getMarks()+", '"+s.getStd()+"', '"+s.getAddress()+"')");
		System.out.println(i+" records inserted");
		System.out.println("Data saved Successfully into the table");
	}
    @Override
    /**
	 * This is the createConnection() method that performs connections to the respective database
	 *
	 */
	public void createConnection(String connectivity, String url, String uName, String pass) throws ClassNotFoundException, SQLException {
		Class.forName(connectivity);
		conn=DriverManager.getConnection(url, uName, pass);		
	}
	@Override
	/**
	 * This is the create() method that performs table creation
	 *
	 */
	public boolean create(String tblName) throws SQLException {
		boolean flag = false;
		stmt=conn.createStatement();
		flag=stmt.execute("create table "+tblName+"(studentName varchar2(30), rollNo int, marks int PRIMARY KEY, std varchar2(10), address varchar2(1000))");
		return !flag;
	}
	@Override
	/**
	 * This is the select() method that performs select opertaions
	 *
	 */
	public ArrayList<Object> select(String columns, String tblName) throws SQLException {
		stmt=conn.createStatement();
		rs=stmt.executeQuery("select "+columns+" from "+tblName);
		ArrayList<Object> list=new ArrayList<Object>();
		while(rs.next()) {
			list.add(rs.getString(1));
			list.add(rs.getInt(2));
			list.add(rs.getInt(3));
			list.add(rs.getString(4));
			list.add(rs.getString(5));
		}
		return list;
	}
	@Override
	/**
	 * This is the insert() method that performs insert opertaions
	 *
	 */
	public int insert(String sql) throws SQLException {
		stmt=conn.createStatement();
		int i=stmt.executeUpdate(sql);
		return i;
	}
	@Override
	/**
	 * This is the update() method that performs update operations
	 *
	 */
	public int update(String name, int rollNo, String tblName) throws SQLException {
		stmt=conn.createStatement();
		int i=stmt.executeUpdate("update "+tblName+" set studentName='"+name+"' where rollNo="+rollNo);
		return i;
	}
	@Override
	/**
	 * This is the delete() method that performs deletion
	 *
	 */
	public int delete(int rollNo, String tblName) throws SQLException {
		stmt=conn.createStatement();
		int i=stmt.executeUpdate("delete from "+tblName+" where rollNo="+rollNo);
		return i;
	}
	@Override
	/**
	 * This is the closeIt() method that performs close operations on connections
	 *
	 */
	public void closeIt() throws SQLException {
		conn.close();
	}
}
