package com.noduco.sb_mongo_junit_demo.service;

import com.noduco.sb_mongo_junit_demo.model.Student;
import com.noduco.sb_mongo_junit_demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    @Autowired
    private StudentRepo srepo;



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

    public Student getStudentById(Integer id) {
        return srepo.findById(id).get();
    }

    public List<Student> getAllStudent(){
        List<Student> allStudent = srepo.findAll();
        return allStudent;

    }

    private List<Student> getAllStudentByName(String name){
        List<Student> allStudentByName = srepo.findStudentsByName(name);
        return allStudentByName;

    }

    public List<Student> getStudentsByNamePublic(String name){
        return getAllStudentByName(name);
    }


    public String deleteStudent(Integer id) {
        Student student = srepo.findById(id).get();
        srepo.deleteById(id);
        return "Student: " +student+" \n has deleted successfully";
    }

    private  String privateMessage(){
        return "Hello world";
    }
    public String privateMethodCaller() {
        return privateMessage() + " Welcome to the Java world.";
    }
}
