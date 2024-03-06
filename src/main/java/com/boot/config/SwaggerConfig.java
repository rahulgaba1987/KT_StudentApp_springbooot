package com.boot.config;

import javax.print.attribute.standard.MediaSize.NA;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;


@OpenAPIDefinition(info =@Info
        (
		title = "Student Application API",
		description = "This API for Student Info",
		termsOfService = "Term & Conditions are applied",
		contact = @Contact(name = "Developed By RKG",
		                   email="rahul@gmail.com",
		                   url = "androjavatech4u.com"),
		license = @License(name="Rahul License"),
		version = "API/V1"),
        servers = {@Server(description = "TestEnv",url = "http://localhost:9091/")
	
                       },security = @SecurityRequirement(name="RKGSecurity")
       
        
)

@SecurityScheme(name = "RKGSecurity", 
                 in = SecuritySchemeIn.HEADER, 
                  type = SecuritySchemeType.HTTP,
                  bearerFormat = "JWT",
                  scheme = "bearer",
                  description = "This is my basic security")
@Configuration
public class SwaggerConfig {

}
