package br.com.rd.pimpolhos.PimpolhosSpring;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;



@EntityScan(basePackages = "br.com.rd.pimpolhos.PimpolhosSpring.model")
@SpringBootApplication
public class PimpolhosSpringApplication implements CommandLineRunner {

	
	public static void main(String[] args) {
		SpringApplication.run(PimpolhosSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}
	
	
}
