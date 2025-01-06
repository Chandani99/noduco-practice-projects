package com.api.mongo.sevice;


import com.api.mongo.model.Course;
import com.api.mongo.model.Student;
import com.api.mongo.repository.CourseRepository;
import com.api.mongo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(String id) {
        return studentRepository.findById(id);
    }

    public Student enrollInCourse(String studentId, String courseId) {
        Optional<Student> studentOpt = studentRepository.findById(studentId);
        Optional<Course> courseOpt = courseRepository.findById(courseId);

        if (studentOpt.isPresent() && courseOpt.isPresent()) {
            Student student = studentOpt.get();
            Course course = courseOpt.get();

            student.getCourses().add(course);  // Add course to student
             // Add student to course

            studentRepository.save(student);  // Save updated student
               // Save updated course

            return student;
        }
        throw new RuntimeException("Student or Course not found");
    }


    public List<Student> getStudentsEnrolledInBothCourses(String course1, String course2    ) {
        return studentRepository.findStudentsEnrolledInBothCourses(course1, course2);
    }


}
