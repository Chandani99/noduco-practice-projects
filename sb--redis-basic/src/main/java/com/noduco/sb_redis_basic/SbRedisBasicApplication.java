package com.noduco.sb_redis_basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories
public class SbRedisBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbRedisBasicApplication.class, args);
	}

}
