package com.HibernateJpa;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class HiberJpaApplication implements CommandLineRunner {



    @Value("${deploy_env}")
    String env;

	public static void main(String[] args) {
		SpringApplication.run(HiberJpaApplication.class, args);
	}




    @Override
    public void run(String... args) throws Exception {
        System.out.println(env);
    }


}
