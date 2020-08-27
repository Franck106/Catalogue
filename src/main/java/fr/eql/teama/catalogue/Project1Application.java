package fr.eql.teama.catalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Project1Application {

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(Project1Application.class);
		app.setAdditionalProfiles("initData", "apikeys");
		ConfigurableApplicationContext context = app.run(args);
		System.out.println("http://localhost:5000/api/proposals");
		//SpringApplication.run(Project1Application.class, args);
	}



}
