package eu.winwinit.bcc.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="dettaglio_ordine")

public class DettaglioOrdine {
	
	// embedded ID
	
	@EmbeddedId
	private DettaglioOrdinePK idDettaglioOrdine;
	@Column(name="quantita")
	private int quantita;
	
    //associazione con la tabella Articolo
	@ManyToOne
	@JoinColumn(name="id_articolo", insertable = false, updatable = false)
	private Articolo articoli;
	
	//associazione con la tabella Ordini
	@ManyToOne
	@JoinColumn(name="id_ordine", insertable = false, updatable = false)
	@JsonIgnore
	private Ordine ordiniArticoli;
	
	public DettaglioOrdine() {}
	
	
	public DettaglioOrdinePK getIdDettaglioOrdine() {
		return idDettaglioOrdine;
	}
	public void setIdDettaglioOrdine(DettaglioOrdinePK idDettaglioOrdine) {
		this.idDettaglioOrdine = idDettaglioOrdine;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}


	public Articolo getArticoli() {
		return articoli;
	}


	public void setArticoli(Articolo articoli) {
		this.articoli = articoli;
	}


	public Ordine getOrdiniArticoli() {
		return ordiniArticoli;
	}


	public void setOrdiniArticoli(Ordine ordiniArticoli) {
		this.ordiniArticoli = ordiniArticoli;
	}
	
	
	
	

}
