//package br.com.rd.pimpolhos.PimpolhosSpring.security;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;
//import br.com.rd.pimpolhos.PimpolhosSpring.repository.ClienteRepository;
//
//@Service
//public class AutenticacaoService implements UserDetailsService{
//	
//	@Autowired
//	private ClienteRepository clienteRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		
//		Optional<Cliente> usuario = clienteRepository.findByEmail(username);
//		
//		if(usuario.isPresent()) {
//			return usuario.get();
//		}
//		throw new UsernameNotFoundException("Dados Inválidos");
//	}
//	
//	
//}
