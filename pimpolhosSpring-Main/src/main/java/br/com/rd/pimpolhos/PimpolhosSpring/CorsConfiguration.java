package br.com.rd.pimpolhos.PimpolhosSpring;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration public class CorsConfiguration implements WebMvcConfigurer { 
	@Override public void addCorsMappings(CorsRegistry registry) { 
		registry.addMapping("/**") .allowedOrigins("http://localhost:3000","https://viacep.com.br/") 
		.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT"); 
	} 
} 