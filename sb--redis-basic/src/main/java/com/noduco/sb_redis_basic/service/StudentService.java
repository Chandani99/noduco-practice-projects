package com.noduco.sb_redis_basic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.noduco.sb_redis_basic.model.Student;

@Service
public class StudentService {
	
	@Autowired
	 private  RedisTemplate srepo;

	private static final String HASH_KEY = "Student";
	
	public Student addStudent(Student student) {
		
		srepo.opsForHash().put(HASH_KEY, student.getId(), student);
		return student;
		
	}
	
//	public String updateStudentInfo(Student student, Integer id) {
//		Student stu = srepo.findById(id).get();
//		stu.setName(student.getName());
//		stu.setCourse(student.getCourse());
//		stu.setClgName(student.getClgName());
//		srepo.save(stu);
//		return "Student data has updated: " + stu;
//	}
	
	public Student getStudentById(Integer id) {
		return (Student) srepo.opsForHash().get(HASH_KEY, id);
	}
	
	public List<Student> getAllStudent(){
		List<Student> allStudent = (List<Student>) srepo.opsForHash().values(HASH_KEY);
		return allStudent;
		
	}
	
	public String deleteStudent(Integer id) {
		Student student = this.getStudentById(id);
		srepo.opsForHash().delete(HASH_KEY, id);
		return "Student: "+student  +"\n has deleted successfully";
	}
}
