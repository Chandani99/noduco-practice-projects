package com.noduco.sb_mongo_basic.reposatory;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.noduco.sb_mongo_basic.model.Student;

@Repository
public interface StudentRepo extends MongoRepository<Student, Integer>{
	@Query("{'courses.courseName': { $all: [?0] } }")
    List<Student> findStudentsByName(String name);
}
