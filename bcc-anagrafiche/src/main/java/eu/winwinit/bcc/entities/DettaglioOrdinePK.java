package eu.winwinit.bcc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DettaglioOrdinePK implements Serializable{
 
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="id_ordine", insertable=false, updatable=false)
	private Integer idOrdine;
	
	@Column(name="id_articolo", insertable=false, updatable=false)
    private Integer idArticolo;
	
	
	
	public Integer getIdOrdine() {
		return idOrdine;
	}
	public void setIdOrdine(Integer idOrdine) {
		this.idOrdine = idOrdine;
	}
	public Integer getIdArticolo() {
		return idArticolo;
	}
	public void setIdArticolo(Integer idArticolo) {
		this.idArticolo = idArticolo;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idArticolo == null) ? 0 : idArticolo.hashCode());
		result = prime * result + ((idOrdine == null) ? 0 : idOrdine.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DettaglioOrdinePK)) {
			return false;
		}
		DettaglioOrdinePK castOther = (DettaglioOrdinePK)other;
		return 
			(this.idOrdine == castOther.idOrdine)
			&& (this.idArticolo == castOther.idArticolo);
	}
	
	
	
	
	
}
