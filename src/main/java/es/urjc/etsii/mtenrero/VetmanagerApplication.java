package es.urjc.etsii.mtenrero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VetmanagerApplication {

	public static String appName = "VetManager";

	public static void main(String[] args) {
		SpringApplication.run(VetmanagerApplication.class, args);
	}
}
