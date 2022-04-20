package br.com.rd.pimpolhos.PimpolhosSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "br.com.rd.pimpolhos.PimpolhosSpring")
@SpringBootApplication
public class PimpolhosSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PimpolhosSpringApplication.class, args);
	}

}
