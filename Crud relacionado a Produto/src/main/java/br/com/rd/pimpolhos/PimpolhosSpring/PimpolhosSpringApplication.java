
package br.com.rd.pimpolhos.PimpolhosSpring;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import br.com.rd.pimpolhos.PimpolhosSpring.service.CategoriaService;
import br.com.rd.pimpolhos.PimpolhosSpring.service.ClienteService;
import br.com.rd.pimpolhos.PimpolhosSpring.service.EnderecoService;
import br.com.rd.pimpolhos.PimpolhosSpring.service.FornecedorService;
import br.com.rd.pimpolhos.PimpolhosSpring.service.ItemPedidoService;
import br.com.rd.pimpolhos.PimpolhosSpring.service.MarcaService;
import br.com.rd.pimpolhos.PimpolhosSpring.service.ProdutoService;
import br.com.rd.pimpolhos.PimpolhosSpring.service.TelefoneService;


@EntityScan(basePackages = "br.com.rd.pimpolhos.PimpolhosSpring.model")
@SpringBootApplication
public class PimpolhosSpringApplication implements CommandLineRunner {
	
	private ClienteService clienteService;
	private TelefoneService telefoneService;
	private EnderecoService enderecoService;
	private ProdutoService produtoService;
	private MarcaService marcaService; 
	private CategoriaService categoriaService;
	private FornecedorService fornecedorService;
	private ItemPedidoService itemPedidoService;
	private Boolean sistema = true;
	
	public PimpolhosSpringApplication(
		ClienteService clienteService, TelefoneService telefoneService, 
		EnderecoService enderecoService, ProdutoService produtoService,
		MarcaService marcaService, CategoriaService categoriaService,
		FornecedorService fornecedorService, ItemPedidoService itemPedidoService) {
		
		this.clienteService = clienteService;
        this.telefoneService = telefoneService;
        this.enderecoService = enderecoService;
        this.produtoService = produtoService;
        this.marcaService = marcaService;
        this.categoriaService = categoriaService;
        this.fornecedorService = fornecedorService;
        this.itemPedidoService = itemPedidoService;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PimpolhosSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int acao;
		
		while(sistema) {
			System.out.println("Qual a ação que será executada?");
			System.out.println("0 - Sair");
			System.out.println("1 - Gestão de Cliente");
			System.out.println("2 - Gestão de Telefone");
			System.out.println("3 - Gestão de Endereco");
			System.out.println("4 - Visualizar Produtos");
			System.out.println("5 - Visualizar Marcas");
			System.out.println("6 - Visualizar Categorias");
			System.out.println("7 - Visualizar Fornecedores");
			System.out.println("8 - Visualizar Item_Pedidos");
			
			
			acao = sc.nextInt();
			if(acao == 1) {
				clienteService.iniciar(sc);
			}else if(acao == 2) {
				telefoneService.iniciar(sc);
			}else if(acao == 3){
				enderecoService.iniciar(sc);
			}else if(acao == 4){
				produtoService.iniciar(sc);
			}else if(acao == 5){
				marcaService.iniciar(sc);
			}else if(acao == 6){
				categoriaService.iniciar(sc);
			}else if(acao == 7){
				fornecedorService.iniciar(sc);
			}else if(acao == 8){
				itemPedidoService.iniciar(sc);
			}else {
				sistema = false;
			}	
		}
		
		sc.close();
		
	}
}
