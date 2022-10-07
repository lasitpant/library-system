package com.hertz.assignment.librarysystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@EnableAutoConfiguration
@SpringBootApplication
//@EnableSwagger2
public class LibrarySystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(LibrarySystemApplication.class, args);
	}

}
