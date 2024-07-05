package com.employee;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
public class SwaggerConfiguration implements WebMvcConfigurer
{
	@Bean
	public Docket getDocket()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("Public-Api's")
				.apiInfo(getApiInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}
	public ApiInfo getApiInfo()
	{
		/*return new ApiInfoBuilder().title("Employee info API")
				.description("Employee API is used to perform the operation on the students")
				.version("1").build();*/
		return new ApiInfo("Student Service Rest API's",
				           "Rest Api for Employee services",
				           "1.0", 
				           "Terms of service",
				           new Contact("prasanth", "www.prasanth.com", "dsjkhf@gmail.com"),
				           "license of api", 
				           "API License URL",
				          Collections.emptyList());
	}

    
	
}
