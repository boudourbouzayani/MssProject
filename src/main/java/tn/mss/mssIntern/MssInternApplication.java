package tn.mss.mssIntern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })

public class MssInternApplication {

	public static void main(String[] args) {
		SpringApplication.run(MssInternApplication.class, args);
	}

}
