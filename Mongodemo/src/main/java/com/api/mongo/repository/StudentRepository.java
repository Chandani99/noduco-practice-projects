package com.api.mongo.repository;

import com.api.mongo.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository  extends MongoRepository<Student, String> {


    @Query("{'courses.courseName': { $all: [?0, ?1] } }")
    List<Student> findStudentsEnrolledInBothCourses(String course1, String course2);
}
