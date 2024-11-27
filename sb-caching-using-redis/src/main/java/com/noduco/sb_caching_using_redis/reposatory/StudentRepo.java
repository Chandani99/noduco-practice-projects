package com.noduco.sb_caching_using_redis.reposatory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.noduco.sb_caching_using_redis.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{
}
