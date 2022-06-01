package com.sdProject.scoreDEI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.sdProject.*")
@EntityScan("com.sdProject.*")
public class ScoreDeiApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ScoreDeiApplication.class, args);
	}

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ScoreDeiApplication.class);
    }
}
