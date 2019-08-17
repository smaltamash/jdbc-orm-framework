package com.jdbc.orm.test;

import java.util.ArrayList;

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
			try{
				jof.createConnection(jof.connectivity, jof.url, jof.userName, jof.pass);
			}
			catch(Exception e) {
				System.out.println("Failed to Establish Connection");
			}
			System.out.println("Connection Established with Database Successfully");
			Student s1=new Student();
			s1.setStudentName("Satya Nadella");
			s1.setRollNo(14);
			s1.setMarks(78);
			s1.setStd("X");
			s1.setAddress("Block D, Microsoft, Redmond, CA");
			String tblName="StudentTable1";
			try{
				boolean flag=jof.create(tblName);
			}
			catch(Exception e) {
				System.out.println("Table not created");
			}
			System.out.println("Table Created Successfully");
			try{
				jof.save(s1, tblName);
			}
			catch(Exception e) {
				System.out.println("Unable to Save");
			}
			Student s2=new Student();
			s2.setStudentName("Sundar Pichai");
			s2.setRollNo(2);
			s2.setMarks(93);
			s2.setStd("XII");
			s2.setAddress("Block A, Google , Mountain View, CA");
			try{
				jof.save(s2, tblName);
			}
			catch(Exception e) {
				System.out.println("Unable to Save");
			}
			Student s3=new Student();
			s3.setStudentName("Larry Page");
			s3.setRollNo(9);
			s3.setMarks(83);
			s3.setStd("XI");
			s3.setAddress("Block F, Google, Mountain View, CA");
			try{
				jof.save(s3, tblName);
			}
			catch(Exception e) {
				System.out.println("Unable to Save");
			}
			ArrayList<Object> list=jof.select("*", tblName);
			System.out.println("Table Data is :-");
			int k=0;
			for(int i=0;i<list.size();i++) {
				k++;
				System.out.print(list.get(i)+"   ");
				if(k==5&&i!=0) {
					System.out.println();
					k=0;
				}
			}
			System.out.println();
			String name="Daisy";
			int a=jof.update(name, s2.getRollNo(), tblName);
			System.out.println(a+" records updated");
			list=jof.select("*", tblName);
			System.out.println("Table Data is :-");
			k=0;
			for(int i=0;i<list.size();i++) {
				k++;
				System.out.print(list.get(i)+"   ");
				if(k==5&&i!=0) {
					System.out.println();
					k=0;
				}
			}
			System.out.println();
			a=jof.delete(s3.getRollNo(), tblName);
			System.out.println(a+" records deleted successfully");
			list=jof.select("*", tblName);
			System.out.println("Table Data is :-");
			k=0;
			for(int i=0;i<list.size();i++) {
				k++;
				System.out.print(list.get(i)+"   ");
				if(k==5&&i!=0) {
					System.out.println();
					k=0;
				}
			}
			System.out.println();
			jof.closeIt();
			System.out.println("Connection Closed Successfully");
		}
		catch(Exception e) {
			System.out.println("Test JDBC ORM Framework Exception");
		}
	}
}
