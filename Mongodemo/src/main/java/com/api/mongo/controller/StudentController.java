package com.api.mongo.controller;


import com.api.mongo.model.Student;
import com.api.mongo.sevice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable String id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/{studentId}/courses/{courseId}")
    public Student enrollInCourse(@PathVariable String studentId, @PathVariable String courseId) {
        return studentService.enrollInCourse(studentId, courseId);
    }

    @GetMapping("/enrolled-in-both")
    public List<Student> getStudentsEnrolledInBothCourses(
            @RequestParam String course1,
            @RequestParam String course2
            ) {
        return studentService.getStudentsEnrolledInBothCourses(course1, course2);
    }
}
