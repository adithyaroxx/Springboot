package com.springbbot.restapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int rollno;
	@Column(name="student_name")
	private String Name;
	@Column(name="student_percentage")
	private float percentage;
	@Column(name="student_branch")
	private String  branch;
	
	public Student() {
		
	}
	
	
	public Student(String name, float percentage, String branch) {
		Name = name;
		this.percentage = percentage;
		this.branch = branch;
	}


	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", Name=" + Name + ", percentage=" + percentage + ", branch=" + branch
				+ "]";
	}

}
