package eu.winwinit.bcc.model;

import java.io.Serializable;
import java.util.List;

import eu.winwinit.bcc.entities.Ordine;

public class OrdineModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Ordine ordine;
	private List<ArticoloRequest> listaArticoliRichiesti;
	
	public Ordine getOrdine() {
		return ordine;
	}
	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}
	public List<ArticoloRequest> getListaArticoliRichiesti() {
		return listaArticoliRichiesti;
	}
	public void setListaArticoliRichiesti(List<ArticoloRequest> listaArticoliRichiesti) {
		this.listaArticoliRichiesti = listaArticoliRichiesti;
	}

}