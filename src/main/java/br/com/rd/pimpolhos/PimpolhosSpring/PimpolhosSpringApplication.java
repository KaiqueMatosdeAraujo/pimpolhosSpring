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
	
	private ClienteService clienteService;
	private TelefoneService telefoneService;
	private Boolean sistema = true;
	
	public PimpolhosSpringApplication(ClienteService clienteService, TelefoneService telefoneService) {
		this.clienteService = clienteService;
       this.telefoneService = telefoneService;
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
			System.out.println("1 - Gestão de Cliente");
			System.out.println("2 - Gestão de Telefone");
			
			acao = sc.nextInt();
			if(acao == 1) {
				clienteService.iniciar(sc);
			}else if(acao == 2) {
				telefoneService.iniciar(sc);
			}else {
				sistema = false;
			}
		}
		sc.close();
	}
	
	
}
