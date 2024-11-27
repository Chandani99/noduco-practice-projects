package com.noduco.sb_redis_basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.noduco.sb_redis_basic.model.Student;
import com.noduco.sb_redis_basic.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService sService;
	
	@PostMapping("/add-student")
	public Student addStudentHandler(@RequestBody Student student) {
		return sService.addStudent(student);
		
	}
	
//	@PutMapping("/update-student/{id}")
//	public String updateStudentHandler(@RequestBody Student student, @PathVariable Integer id) {
//		return sService.updateStudentInfo(student, id);
//	}
//	
	@DeleteMapping("/delete-student")
	public String deleteStudentHandler(@RequestParam Integer id) {
		return sService.deleteStudent(id);
	}
	
	@GetMapping("/get-student")
	public Student getStudentById(@RequestParam Integer id) {
		return sService.getStudentById(id);
		
	}
	
	@GetMapping("/get-all-student")
	public List<Student> getAllStudentHandler(){
		return sService.getAllStudent();
	}
}
