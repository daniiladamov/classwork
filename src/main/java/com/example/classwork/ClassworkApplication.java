package com.example.classwork;

import com.example.classwork.entity.Cat;
import com.example.classwork.entity.Dog;
import com.example.classwork.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClassworkApplication {


	public static void main(String[] args) {
		SpringApplication.run(ClassworkApplication.class, args);
	}

}
