package com.expt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@ComponentScan({"com.expt.repository"})
//@EnableJpaRepositories(basePackages = "com.expt.repository", entityManagerFactoryRef = "sessionFactory")
@SpringBootApplication
public class ExptApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExptApplication.class, args);
	}

}
