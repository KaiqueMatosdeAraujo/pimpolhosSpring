package br.com.rd.pimpolhos.PimpolhosSpring.model;

import java.time.LocalDate;
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

	@Override
	public String toString() {
		return "Pedido [codPedido=" + codPedido + ", dataPedido=" + dataPedido + "]";
	}
	

	
	
	
}
