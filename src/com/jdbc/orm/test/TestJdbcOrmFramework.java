package com.jdbc.orm.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.orm.JdbcOrmFramework;
import com.jdbc.orm.Student;
public class TestJdbcOrmFramework {
	public static void main(String args[]) {
		try{
			JdbcOrmFramework jof=new JdbcOrmFramework();
			jof.connectivity="oracle.jdbc.driver.OracleDriver";
			jof.url="jdbc:oracle:thin:@localhost:1521:xe";
			jof.userName="hr";
			jof.pass="hr";
			jof.createConnection(jof.connectivity, jof.url, jof.userName, jof.pass);
			System.out.println("Connection Established with Database Successfully");
			Student s1=new Student();
			s1.setStudentName("Kanika");
			s1.setRollNo(14);
			s1.setMarks(78);
			s1.setStd("X");
			s1.setAddress("Block D, Kalindi Colony, New Delhi, Delhi - 118876");
			String tblName="StudentTable1";
			boolean flag=jof.create(tblName);
			if(flag) {
				System.out.println("Table Created Successfully");
			}
			else {
				System.out.println("Table not created");
			}
			jof.save(s1, tblName);
			Student s2=new Student();
			s2.setStudentName("Naina");
			s2.setRollNo(2);
			s2.setMarks(93);
			s2.setStd("XII");
			s2.setAddress("Block A, Lajpat Nagar - III , New Delhi, Delhi - 110024");
			jof.save(s2, tblName);
			Student s3=new Student();
			s3.setStudentName("Saniya");
			s3.setRollNo(9);
			s3.setMarks(83);
			s3.setStd("XI");
			s3.setAddress("Block F, Sarojni Nagar , New Delhi, Delhi - 110989");
			jof.save(s3, tblName);
			ResultSet rs=jof.select("*", tblName);
			System.out.println("Table Data is :-");
			while(rs.next()) {
				System.out.println(rs.getString(1)+"   "+rs.getInt(2)+"   "+rs.getInt(3)+"   "+rs.getString(4)+"   "+rs.getString(5));
			}
			String name="Daisy";
			int a=jof.update(name, s2.getRollNo(), tblName);
			System.out.println(a+" records updated");
			rs=jof.select("*", tblName);
			System.out.println("Table Data is :-");
			rs=jof.select("*", tblName);
			while(rs.next()) {
				System.out.println(rs.getString(1)+"   "+rs.getInt(2)+"   "+rs.getInt(3)+"   "+rs.getString(4)+"   "+rs.getString(5));
			}
			a=jof.delete(s3.getRollNo(), tblName);
			System.out.println(a+" records deleted successfully");
			rs=jof.select("*", tblName);
			System.out.println("Table Data is :-");
			while(rs.next()) {
				System.out.println(rs.getString(1)+"   "+rs.getInt(2)+"   "+rs.getInt(3)+"   "+rs.getString(4)+"   "+rs.getString(5));
			}
			jof.closeIt();
			System.out.println("Connection Closed Successfully");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
