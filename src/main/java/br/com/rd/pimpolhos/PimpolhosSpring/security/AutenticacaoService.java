package br.com.rd.pimpolhos.PimpolhosSpring.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.ClienteRepository;

@Service
public class AutenticacaoService implements UserDetailsService{
	
	@Autowired
	private ClienteRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		Optional<Cliente> usuario = repository.findByEmail(username);
		if(usuario.isPresent()) {
			return usuario.get();
			
		}
	    throw new UsernameNotFoundException("Dados Inválidos");
	}
	

	
}
