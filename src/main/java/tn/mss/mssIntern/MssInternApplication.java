package tn.mss.mssIntern;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import tn.mss.mssIntern.modele.User;
import tn.mss.mssIntern.repositories.UserRepository;

import java.util.stream.Stream;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })

public class MssInternApplication {

	public static void main(String[] args) {
		SpringApplication.run(MssInternApplication.class, args);
	}

}
