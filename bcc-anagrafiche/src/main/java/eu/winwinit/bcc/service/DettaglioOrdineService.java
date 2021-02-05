package eu.winwinit.bcc.service;

import eu.winwinit.bcc.entities.DettaglioOrdine;
import eu.winwinit.bcc.entities.Ordine;
import eu.winwinit.bcc.model.ArticoloRequest;

public interface DettaglioOrdineService {
	
	public void save(ArticoloRequest ar, Ordine ordine);

	public void delete(DettaglioOrdine d);

	public void save(DettaglioOrdine d);

}
