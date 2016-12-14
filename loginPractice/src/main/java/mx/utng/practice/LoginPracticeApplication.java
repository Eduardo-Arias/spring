package mx.utng.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class LoginPracticeApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder appplication){
		return appplication.sources(LoginPracticeApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(LoginPracticeApplication.class, args);
	}
}
