package com.jsp.college.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	
	
	@Bean
	public OpenAPI swaggerDocOpenApi() {

		Contact contact = new Contact();
		contact.setName("Puneeth");
		contact.setEmail("puneeths2000@gmail.com");
		contact.setUrl("www.linkedin.com/in/puneeth-s-bb7011204");


		Info info = new Info();
		info.title("College Database");
		info.version("1.0.0");
		info.contact(contact);
		info.description("This application is developed using spring boot");
		info.termsOfService("");

		OpenAPI openAPI = new OpenAPI();
		openAPI.info(info);

		return openAPI;
	}

}
