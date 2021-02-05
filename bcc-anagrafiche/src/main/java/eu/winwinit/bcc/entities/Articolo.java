package eu.winwinit.bcc.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="articoli")
public class Articolo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	
	@Column(name="tipo")
	private String tipo;
	@Column(name="descrizione")
	private String descrizione;
	
//	associazione con la tabella del dettaglio ordini
	@OneToMany(mappedBy="articoli")
	private List<DettaglioOrdine> dettaglioOrdini; 
	
	
	public Articolo() {};
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	@Override
	public String toString() {
		return "Articolo [id=" + id + ", tipo=" + tipo + ", descrizione=" + descrizione + "]";
	}
	
	public Articolo(Integer id, String tipo, String descrizione) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.descrizione = descrizione;
	}
	
	@JsonIgnore
	public List<DettaglioOrdine> getDettaglioOrdini() {
		return this.dettaglioOrdini;
	}

	public void setDettaglioOrdini(List<DettaglioOrdine> dettaglioOrdini) {
		this.dettaglioOrdini = dettaglioOrdini;
	}

	
	public void cambiaArticolo(Articolo articolo) {
		if(this!=null) {
		if(articolo.getTipo() != null) this.setTipo(articolo.getTipo());
		if(articolo.getDescrizione() != null) this.setDescrizione(articolo.getDescrizione());
		if(articolo.getDettaglioOrdini()!=null) this.setDettaglioOrdini(articolo.getDettaglioOrdini());
		}
	}
	

}
