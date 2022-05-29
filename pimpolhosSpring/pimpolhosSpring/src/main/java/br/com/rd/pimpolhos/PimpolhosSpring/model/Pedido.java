package br.com.rd.pimpolhos.PimpolhosSpring.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codPedido;
	
	@Column(nullable = false)
	private LocalDate dataPedido;
//	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	

	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "codFrete") 
	private Frete frete; 
	
	@ManyToOne (fetch = FetchType.EAGER) 
	@JoinColumn(name = "codStatus") 
	private StatusPedido statusPedido; 
	
	
	@OneToMany(mappedBy="codPedido", cascade = CascadeType.ALL)
	private List<ItemPedido> itemPedido;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codPagamento")
	private Pagamento pagamento;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="codCliente")
	private Cliente cliente;
	
	//alteração
	@ManyToOne(fetch=FetchType.EAGER )
	@JoinColumn(name="codEndereco")
	private Endereco endereco;
	
	
	@OneToOne(mappedBy = "pedido")
	private NotaFiscal notaFiscal;
	
	public Pedido() {}
	
//	public Pedido(LocalDate dataPedido, Frete frete, StatusPedido statusPedido,
//			List<ItemPedido> itemPedido, Pagamento pagamento, Cliente cliente) {
//		this.dataPedido = dataPedido;
//		this.frete = frete;
//		this.statusPedido = statusPedido;
//		this.itemPedido = itemPedido;
//		this.pagamento = pagamento;
//		this.cliente = cliente;
//	}
// funcional
//	public Pedido(Date dataPedido ,Cliente cliente , Frete frete, Pagamento pagamento ,StatusPedido statusPedido) throws ParseException {
//		this.dataPedido = dataPedido;
//		this.cliente = cliente;
//		this.frete = frete;
//		this.statusPedido = statusPedido;
//		this.pagamento = pagamento;
//	}
	
	//alteração
	public Pedido(LocalDate dataPedido, Frete frete, StatusPedido statusPedido, Pagamento pagamento, Cliente cliente,
			Endereco endereco) {
		super();
		this.dataPedido = dataPedido;
		this.frete = frete;
		this.statusPedido = statusPedido;
		this.pagamento = pagamento;
		this.cliente = cliente;
		this.endereco = endereco;
	}

	
	

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Integer getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(Integer codPedido) {
		this.codPedido = codPedido;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}


	public Frete getFrete() {
		return frete;
	}

	public void setFrete(Frete frete) {
		this.frete = frete;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}
	

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	

//	public Telefone getTelefone() {
//		return telefone;
//	}
//
//	public void setTelefone(Telefone telefone) {
//		this.telefone = telefone;
//	}

	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	@Override
	public String toString() {
		return "Pedido [codPedido=" + codPedido + ", dataPedido=" + dataPedido + "]";
	}

}