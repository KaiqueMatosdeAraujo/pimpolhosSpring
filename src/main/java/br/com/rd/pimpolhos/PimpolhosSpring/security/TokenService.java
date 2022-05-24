//package br.com.rd.pimpolhos.PimpolhosSpring.security;
//
//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Value;

//import org.springframework.stereotype.Service;
//
//import br.com.rd.queroserdev.forum.modelo.Usuario;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//@Service
//public class TokenService {
//
//	@Value("${forum.jwt.expiration}")
//	private String expiration;
//	
//	@Value("${forum.jwt.secret}")
//	private String secret;  
//	
//	public String gerarToken(Authentication authentication) {
//		Usuario logado = (Usuario) authentication.getPrincipal();
//		Date hoje = new Date();
//		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
//		return Jwts.builder()
//				.setIssuer("Fórum utilizando Serviços Rest com Spring Boot")
//				.setSubject(logado.getId().toString())
//				.setIssuedAt(hoje)
//				.setExpiration(dataExpiracao)
//				.signWith(SignatureAlgorithm.HS256, secret)
//				.compact();
//	}
//
//	public boolean isTokenValido(String token) {
//		try {
//			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
//			return true;
//		}
//		catch(Exception e) {
//			return false;
//		}
//
//	}
//
//	public Long getIdUsuario(String token) {
//		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
//		
//		return Long.parseLong(claims.getSubject());
//	}
//
//}
