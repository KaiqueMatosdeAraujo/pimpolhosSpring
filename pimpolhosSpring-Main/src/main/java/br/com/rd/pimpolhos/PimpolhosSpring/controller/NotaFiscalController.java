//package br.com.rd.pimpolhos.PimpolhosSpring.controller;
//
//import java.net.URI;
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import br.com.rd.pimpolhos.PimpolhosSpring.dto.NotaFiscalDTO;
//import br.com.rd.pimpolhos.PimpolhosSpring.model.NotaFiscal;
//import br.com.rd.pimpolhos.PimpolhosSpring.repository.NotaFiscalRepository;
//import br.com.rd.pimpolhos.PimpolhosSpring.service.NotaFiscalService;
//
//@RestController
//@RequestMapping("/notaFiscal")
//public class NotaFiscalController {
//
//	@Autowired
//	private NotaFiscalRepository notaFiscalRepository;
//	@Autowired
//	private NotaFiscalService notaFiscalService;
//	
//	
//	@GetMapping
//	public List<NotaFiscal> listar() {
//		List<NotaFiscal> notaFiscal = notaFiscalRepository.findAll();
//		return notaFiscal;
//	}
//	
//	@GetMapping("listar") 
//	public List<NotaFiscalDTO> listarNotaFiscal() { 
//		List<NotaFiscal> notaFiscal = notaFiscalRepository.findAll(); 
//		return NotaFiscalDTO.converter(notaFiscal); 
//	} 
//	
//	@PostMapping("/cadastrar")
//	@Transactional
//	public ResponseEntity<NotaFiscal> cadastrar(@RequestBody @Valid NotaFiscal notaFiscal, UriComponentsBuilder uriBuilder){
//		notaFiscalService.salvar(notaFiscal);
//		URI uri = uriBuilder.path("/notaFiscal/{id}").buildAndExpand(notaFiscal.getCodNf()).toUri();
//		return ResponseEntity.created(uri).body(notaFiscal);
//		
//	}
//	
//}
