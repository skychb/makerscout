package com.makerscouts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.makerscouts.configure.Thymeleaf3AutoConfiguration;


@Import(Thymeleaf3AutoConfiguration.class)
@SpringBootApplication(exclude = ThymeleafAutoConfiguration.class)
public class MakerscoutsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MakerscoutsApplication.class, args);
	}
	
	@Bean(name = "uploadPath")
	public String uploadPath() {
	    return "d:/image/";
	}
}
