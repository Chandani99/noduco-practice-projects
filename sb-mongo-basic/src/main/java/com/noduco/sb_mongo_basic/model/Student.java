package com.noduco.sb_mongo_basic.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "student")
@Data

public class Student {
	
	@Id
	private Integer id;
	private String name;
	private String course;
	private String clgName;
	
	
	
	public Student() {
		super();
	}



	public Student(Integer id, String name, String course, String clgName) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
		this.clgName = clgName;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCourse() {
		return course;
	}



	public void setCourse(String course) {
		this.course = course;
	}



	public String getClgName() {
		return clgName;
	}



	public void setClgName(String clgName) {
		this.clgName = clgName;
	}



	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", course=" + course + ", clgName=" + clgName + "]";
	}
	
	
	
	
}
