package es.urjc.etsii.mtenrero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class VetmanagerApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(VetmanagerApplication.class);
	}

	public static String appName = "VetManager";

	public static void main(String[] args) {
		SpringApplication.run(VetmanagerApplication.class, args);
	}
}
