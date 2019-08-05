package com.jdbc.orm;
public class Student {
	public String studentName;
	public int rollNo;
	public int marks;
	public String std;
	public String address;
	public Student() {
		super();
	}
	public Student(String studentName, int rollNo, int marks, String std, String address) {
		super();
		this.studentName = studentName;
		this.rollNo = rollNo;
		this.marks = marks;
		this.std = std;
		this.address = address;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getStd() {
		return std;
	}
	public void setStd(String std) {
		this.std = std;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}		
}
