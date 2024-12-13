package com.noduco.sb_mongo_basic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.noduco.sb_mongo_basic.model.Student;
import com.noduco.sb_mongo_basic.reposatory.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo srepo;
	 
	
	@CachePut(value = "students", key = "#student.id")
	public Student addStudent(Student student) {
		srepo.save(student);
		return student;
		
	}
	
	public String updateStudentInfo(Student student, Integer id) {
		Student stu = srepo.findById(id).get();
		stu.setName(student.getName());
		stu.setCourse(student.getCourse());
		stu.setClgName(student.getClgName());
		srepo.save(stu);
		return "Student data has updated: " + stu;
	}
	
	@Cacheable(value = "students", key = "#id")
	public Student getStudentById(Integer id) {
		return srepo.findById(id).get();
	}
	
	public List<Student> getAllStudent(){
		List<Student> allStudent = srepo.findAll();
		return allStudent;
		
	}
	
	private List<Student> getAllStudentByName(String name){
		List<Student> allStudent = srepo.findStudentsByName(name);
		return allStudent;
		
	}
	
	
	 @CacheEvict(value = "students", key = "#id")
	
	public String deleteStudent(Integer id) {
		Student student = srepo.findById(id).get();
		srepo.deleteById(id);
		return "Student: " +student+" \n has deleted successfully";
	}
}
