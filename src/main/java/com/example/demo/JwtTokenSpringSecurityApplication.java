package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@SpringBootApplication

public class JwtTokenSpringSecurityApplication {
	@Autowired
	private UserRepository repository;
	@PostConstruct
	public void initUsers()
	{
		List<User>users=Stream.of(new User(101,"javatechi","password","javatechi@gmail.com"),new User(102,"dasu","password","dasu@gmail.com"))
				.collect(Collectors.toList());
		repository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(JwtTokenSpringSecurityApplication.class, args);
	}

}
