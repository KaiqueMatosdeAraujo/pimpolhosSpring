//package br.com.rd.pimpolhos.PimpolhosSpring.service;
//
//import javax.mail.MessagingException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.ComponentScan;
//
//
//@SpringBootApplication
//@ComponentScan({"br.com.rd.pimpolhos.PimpolhosSpring"})
//public class ServicoEmail implements CommandLineRunner{
//
//	@Autowired
//	private final EnviaEmailService enviaEmailService;
//	
//	public ServicoEmail(EnviaEmailService enviaEmailService) {
//		this.enviaEmailService = enviaEmailService;
//	}
//	
//	public static void main(String[] args) {
//		SpringApplication.run(ServicoEmail.class, args);
//	}
//	
//	@Override
//	public void run(String... args) throws MessagingException{
//		enviaEmailService.enviar("kathleen12@gmail.com", "Teste envio email", "Conteudo do email");
//	}
//	
//	
//	
////    public void testEnvioEmail() {
////		enviaEmailService.enviar();
////    }
////
////	@Override
////	public void run(String... args) throws Exception {
////		
////		
////	}
//	
//	
//	
//	
//	
//	
//}
