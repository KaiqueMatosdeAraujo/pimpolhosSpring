package br.com.rd.pimpolhos.PimpolhosSpring;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import br.com.rd.pimpolhos.PimpolhosSpring.service.ClienteService;
import br.com.rd.pimpolhos.PimpolhosSpring.service.TelefoneService;


@EntityScan(basePackages = "br.com.rd.pimpolhos.PimpolhosSpring.model")
@SpringBootApplication
public class PimpolhosSpringApplication implements CommandLineRunner {
	
	private TelefoneService telefoneService;
	private ClienteService clienteService;
	private Boolean sistema = true;
	
	
	
	public PimpolhosSpringApplication(TelefoneService telefoneService, ClienteService clienteService) {
		super();
		this.telefoneService = telefoneService;
		this.clienteService = clienteService;
	}

	public static void main(String[] args) {
		SpringApplication.run(PimpolhosSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int acao;
		
		while(sistema) {
			System.out.println("Qual a ação que será executada?");
			System.out.println("0 - Sair");
			System.out.println("1 - Gestão de Cargos");
			
			
			acao = sc.nextInt();
			if(acao == 1) {
				clienteService.iniciar(sc);
			}else{
				telefoneService.iniciar(sc);
			}
		}
		sc.close();
	}
	
	
}
