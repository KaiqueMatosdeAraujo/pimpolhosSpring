package br.com.rd.pimpolhos.PimpolhosSpring;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
//	public static void main(String[] args) {
//	System.out.println(new BCryptPasswordEncoder().encode("gonzaga7"));
//	
//}

	@Override
	public void run(String... args) throws Exception {
//		Scanner sc = new Scanner(System.in);
//		int acao;
//		
//		while(sistema) {
//			System.out.println("Qual a ação que será executada?");
//			System.out.println("0 - Sair");
//			System.out.println("1 - Gestão de Cliente");
//			System.out.println("2 - Gestão de Telefone");
//			System.out.println("3 - Gestão de Endereço");
//			
//			acao = sc.nextInt();
//			if(acao == 1) {
//				clienteService.iniciar(sc);
//			}else if(acao == 2) {
//				telefoneService.iniciar(sc);
//			}else if(acao == 3) {
//				enderecoService.iniciar(sc);
//			}else {
//				sistema = false;
//			}
//		}
//		sc.close();
	}
	
}
