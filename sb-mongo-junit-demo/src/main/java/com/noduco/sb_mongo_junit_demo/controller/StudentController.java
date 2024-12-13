package com.noduco.sb_mongo_junit_demo.controller;

import com.noduco.sb_mongo_junit_demo.model.Student;
import com.noduco.sb_mongo_junit_demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService sService;

    @PostMapping("/add-student")
    public Student addStudentHandler(@RequestBody Student student) {
        return sService.addStudent(student);

    }

    @PutMapping("/update-student/{id}")
    public String updateStudentHandler(@RequestBody Student student, @PathVariable Integer id) {
        return sService.updateStudentInfo(student, id);
    }

    @DeleteMapping("/delete-student")
    public String deleteStudentHandler(@RequestParam Integer id) {
        return sService.deleteStudent(id);
    }

    @GetMapping("/get-student/{studentId}")
    public Student getStudentById(@PathVariable Integer studentId) {
        return sService.getStudentById(studentId);

    }

    @GetMapping("/get-all-student")
    public List<Student> getAllStudentHandler(){
        return sService.getAllStudent();
    }
}
