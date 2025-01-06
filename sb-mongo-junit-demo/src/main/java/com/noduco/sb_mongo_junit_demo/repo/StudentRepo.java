package com.noduco.sb_mongo_junit_demo.repo;

import com.noduco.sb_mongo_junit_demo.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends MongoRepository<Student, Integer> {
    @Query("{'courses.courseName': { $all: [?0] } }")
    List<Student> findStudentsByName(String name);
}
