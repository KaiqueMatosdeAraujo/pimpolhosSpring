//package br.com.rd.pimpolhos.PimpolhosSpring.security;
//
//import java.io.IOException;
//
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;
//import br.com.rd.pimpolhos.PimpolhosSpring.repository.ClienteRepository;
//
//public class AutenticacaoTokenFilter extends OncePerRequestFilter{
//
//	private TokenService tokenService;
//	private ClienteRepository clienteRepository;
//	
//	
//	public AutenticacaoTokenFilter(TokenService tokenService, ClienteRepository clienteRepository) {
//		this.tokenService = tokenService;
//		this.clienteRepository = clienteRepository;
//	}
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, 
//									HttpServletResponse response, 
//									FilterChain filterChain)
//			throws ServletException, IOException {
//
//		String token  = recuperarToken(request);
//		System.out.println(token);
//		
//		boolean valido =  tokenService.isTokenValido(token);
//		System.out.println(valido);
//		
//		if(valido) {
//			autenticarCliente(token);
//		}
//		
//		filterChain.doFilter(request, response);
//		
//	}
//
//	private void autenticarCliente(String token) {
//		Long codCliente = tokenService.getIdUsuario(token);
//		Cliente cliente = clienteRepository.findById(idUsuario).get();
//		
//		//UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
//		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(cliente.getEmail(), cliente.getSenha(), cliente.getAuthorities());
//		
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//	}
//
//	private String recuperarToken(HttpServletRequest request) {
//		String token  = request.getHeader("Authorization");
//		
//		if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
//			return null;
//		}
//		
//		return token.substring(7, token.length());
//	}
//}
