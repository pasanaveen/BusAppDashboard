package com.xpo.app;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author npasagadi
 *
 */

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	/*
	 * use http://localhost:8080/v2/api-docs to view the swagger documentation as a
	 * json format use http://localhost:8080/swagger-ui.html to view the document as
	 * a html page.
	 */
	public static final Contact DEFAULT_CONTACT = new Contact("BusApp Dashborad", "busappdashboard.com",
			"busappdashboard.xpo.com");
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("BusApp Dashborad Documentation",
			"One stop information for business applicatioins", "1.0", "urn:tos", DEFAULT_CONTACT, "Apache 2.0",
			"http://www.apache.org/licenses/LICENSE-2.0");
	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(
			Arrays.asList("application/json", "application/xml"));

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).
				apiInfo(DEFAULT_API_INFO)
				.produces(DEFAULT_PRODUCES_AND_CONSUMES) // Sets the Produces as JSON and XML in documentation
				.consumes(DEFAULT_PRODUCES_AND_CONSUMES); // Sets the Consumes as JSON and XML
	}

}
