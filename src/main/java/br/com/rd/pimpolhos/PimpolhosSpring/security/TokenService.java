package br.com.rd.pimpolhos.PimpolhosSpring.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	@Value("${forum.jwt.expiration}")
	private String expiration;
	
	@Value("${forum.jwt.secret}")
	private String secret;

	public String gerarToken(Authentication authentication) {
		Cliente logado = (Cliente) authentication.getPrincipal();
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
		return Jwts
				.builder()
				.setIssuer("Projeto Pimpolhos")
				.setSubject(logado.getCodCliente().toString())
				.setIssuedAt(hoje)
				.setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256 , secret).compact();
		
		
		
		
		
	}

	public boolean isTokenValido(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public Integer getIdCliente(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Integer.parseInt(claims.getSubject());
	}

}
