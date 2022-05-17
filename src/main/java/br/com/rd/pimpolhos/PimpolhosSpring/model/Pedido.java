package br.com.rd.pimpolhos.PimpolhosSpring.model;

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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.rd.pimpolhos.PimpolhosSpring.repository.ClienteRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.FreteRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.ItemPedidoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.PagamentoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.StatusPedidoRepository;

@Entity
@Table(name="pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codPedido;
	
	@Column(nullable = false)
	private LocalDate dataPedido;
	

	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "codFrete") 
	private Frete frete; 
	
	@ManyToOne (fetch = FetchType.EAGER) 
	@JoinColumn(name = "codStatus") 
	private StatusPedido statusPedido; 
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="codItemPedido")
	private List<ItemPedido> itemPedido;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codPagamento")
	private Pagamento pagamento;
	
	@ManyToOne(fetch=FetchType.EAGER , cascade = CascadeType.ALL)
	@JoinColumn(name="codCliente")
	private Cliente cliente;
	
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

	public Pedido(Cliente cliente ,LocalDate dataPedido, Frete frete, StatusPedido statusPedido, Pagamento pagamento) {
		this.cliente = cliente;
		this.dataPedido = dataPedido;
		this.frete = frete;
		this.statusPedido = statusPedido;
		this.pagamento = pagamento;
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

	@Override
	public String toString() {
		return "Pedido [codPedido=" + codPedido + ", dataPedido=" + dataPedido + "]";
	}

}
