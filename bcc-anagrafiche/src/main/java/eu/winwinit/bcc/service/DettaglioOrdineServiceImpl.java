package eu.winwinit.bcc.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.winwinit.bcc.entities.DettaglioOrdine;
import eu.winwinit.bcc.entities.DettaglioOrdinePK;
import eu.winwinit.bcc.entities.Ordine;
import eu.winwinit.bcc.model.ArticoloRequest;
import eu.winwinit.bcc.repository.DettaglioOrdineRepository;

@Service("dettaglioOrdineService")
public class DettaglioOrdineServiceImpl implements DettaglioOrdineService {
	
	@Autowired
	private DettaglioOrdineRepository dettaglioOrdineRepository;
	
	//il metodo save consente di salvare adeguatamente l'ordine, popolando l'oggetto in ogni campo con le dovute informazioni
	@Override
	public void save(ArticoloRequest a, Ordine ordine) {
		
		DettaglioOrdine dettaglioOrdine = new DettaglioOrdine();
		DettaglioOrdinePK dettaglioOrdinePK = new DettaglioOrdinePK();
		dettaglioOrdinePK.setIdArticolo(a.getIdArticolo());
		dettaglioOrdinePK.setIdOrdine(ordine.getId());
		dettaglioOrdine.setIdDettaglioOrdine(dettaglioOrdinePK);
		dettaglioOrdine.setQuantita(a.getQuantita());		
		dettaglioOrdineRepository.save(dettaglioOrdine);
	}
	
	public void delete(DettaglioOrdine det) {
		dettaglioOrdineRepository.delete(det);
	}

	@Override
	public void save(DettaglioOrdine det) {
		dettaglioOrdineRepository.save(det);
		
	}

}
