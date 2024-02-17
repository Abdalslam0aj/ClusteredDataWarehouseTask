package com.interview.task.deals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(
        title = "Deals micro service API documentation",
        description = "Deals micro service API documentation",
        version = "v1",
        contact = @Contact(
            name = "Abdulsalam aljamal",
            email = "abodajaljaml@gmail.com"
        )
    ),
    externalDocs = @ExternalDocumentation(
        
    )
)
public class InterviewTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewTaskApplication.class, args);
	}

}
