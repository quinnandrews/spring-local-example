package io.github.quinnandrews.spring.local.example;

import io.github.quinnandrews.spring.local.postgresql.config.EnableLocalPostgreSQL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@EnableLocalPostgreSQL
@Profile("local")
@SpringBootApplication
public class LocalDevApplication {

	public static void main(final String[] args) {
		final var springApplication = new SpringApplication(Application.class);
		springApplication.setAdditionalProfiles("local");
		springApplication.run(args);
	}
}
