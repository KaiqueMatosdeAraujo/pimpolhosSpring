//package br.com.rd.pimpolhos.PimpolhosSpring.service;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EnviaEmailService {
//
//	
//	private final JavaMailSender javaMailSender;
//	
//	public  EnviaEmailService(final JavaMailSender javaMailSender) {
//		this.javaMailSender = javaMailSender;
//	}
//	
//	public void enviar(String para, String titulo, String conteudo) {
//		System.out.println("Enviando e-mail simples");
//		
//		var mensagem = new SimpleMailMessage();
//		mensagem.setTo(para);
//		
//		mensagem.setSubject(titulo);
//		mensagem.setText(conteudo);
//		javaMailSender.send(mensagem);
//		System.out.println(mensagem);
//		System.out.println("E-mail enviado com sucesso");
//	}
//	
////	 public  void enviar() {
////	        SimpleMailMessage email = new SimpleMailMessage();
////	        email.setTo("isabellabotasso20@gmail.com");
////	        email.setSubject("Teste envio de e-mail");
////	        email.setText("Enviei este e-mail usando Spring Boot.");
////	        javaMailSender.send(email);
////	    }
//	
//	
//	
////	public void enviarEmailComAnexo(String para, String titulo, String conteudo, String arquivo, String attachmentFilename) throws MessagingException {
////		System.out.println("Enviando e-mail com anexo");
////		MimeMessage mensagem = javaMailSender.createMimeMessage();
////		
////		var helper = new MimeMessageHelper(mensagem, true);
////		
////		helper.setTo(para);
////		helper.setSubject(titulo);
////		helper.setText(conteudo, true);
////		
////		helper.addAttachment(attachmentFilename= "image1.jpeg", new ClassPathResource(arquivo));
////		
////		javaMailSender.send(mensagem);
////		System.out.println("E-mail com anexo enviado");
////	}
//	
//	
//	
//	
//	
//	
//	
//}
