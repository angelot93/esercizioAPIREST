package eu.winwinit.bcc.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="ordini")
public class Ordine {
	
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="id_ordine",nullable= false,unique= true)
	 private Integer id;
	 
	 @Column(name="data")
	 @JsonFormat(pattern = "dd/MM/yyyy")
	 private LocalDate data;
	 
	 @Column(name="nome_cliente")
	 private String nomeCliente;
	 
	 @Column(name="prezzo_tot")
	 private Integer prezzoTot;
	 
	
	@OneToMany(mappedBy="ordiniArticoli")
	 private List<DettaglioOrdine> dettaglioOrdini;

	public Ordine() {}
	 
	 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public Integer getPrezzoTot() {
		return prezzoTot;
	}
	public void setPrezzoTot(Integer prezzoTot) {
		this.prezzoTot = prezzoTot;
	}

	public List<DettaglioOrdine> getDettaglioOrdini() {
		return dettaglioOrdini;
	}

	public void setDettaglioOrdini(List<DettaglioOrdine> dettaglioOrdini) {
		this.dettaglioOrdini = dettaglioOrdini;
	}
	

}
