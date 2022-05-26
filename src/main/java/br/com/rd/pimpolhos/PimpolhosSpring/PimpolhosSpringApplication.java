package br.com.rd.pimpolhos.PimpolhosSpring;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import br.com.rd.pimpolhos.PimpolhosSpring.service.ClienteService;
import br.com.rd.pimpolhos.PimpolhosSpring.service.EnderecoService;
import br.com.rd.pimpolhos.PimpolhosSpring.service.TelefoneService;

@EntityScan(basePackages = "br.com.rd.pimpolhos.PimpolhosSpring.model")
@SpringBootApplication
public class PimpolhosSpringApplication implements CommandLineRunner {
	
	private ClienteService clienteService;
	private TelefoneService telefoneService;
	private EnderecoService enderecoService;
	private Boolean sistema = true;
	
	public PimpolhosSpringApplication(ClienteService clienteService, TelefoneService telefoneService, EnderecoService enderecoService) {
	   this.clienteService = clienteService;
       this.telefoneService = telefoneService;
       this.enderecoService = enderecoService;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PimpolhosSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
	
	
}
