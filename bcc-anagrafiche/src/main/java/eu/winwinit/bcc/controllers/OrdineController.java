package eu.winwinit.bcc.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.winwinit.bcc.constants.AuthorityRolesConstants;
import eu.winwinit.bcc.entities.DettaglioOrdine;
import eu.winwinit.bcc.entities.Ordine;
import eu.winwinit.bcc.model.ArticoloRequest;
import eu.winwinit.bcc.model.OrdineModel;
import eu.winwinit.bcc.service.DettaglioOrdineService;
import eu.winwinit.bcc.service.OrdineService;

    @RestController
	@RequestMapping("/ordini")
	public class OrdineController {
		
		@Autowired
		OrdineService ordineService;
		
		@Autowired
		DettaglioOrdineService dettaglioOrdineService;
		
		
		//trova ordine in base all'ID
		@RequestMapping(value = "/cercaOrdine/{id}", method = RequestMethod.GET)
		public ResponseEntity<Ordine> findOrdineById (
				@RequestHeader(value=AuthorityRolesConstants.HEADER_STRING) String jwtToken,
				@PathVariable Integer id
				) { 
			
			Ordine ordine = ordineService.findById(id);
			
			System.out.println(ordine.getDettaglioOrdini().size());
		
			return new ResponseEntity<>(ordine, HttpStatus.OK);
		}
		//crea un nuovo ordine
		@RequestMapping(value="/creaOrdine",method = RequestMethod.POST)
	    public ResponseEntity<?> createOrdine (
	    		@RequestHeader(value=AuthorityRolesConstants.HEADER_STRING) String jwtToken,
	    		@RequestBody OrdineModel ordineModel
	    		) {
			
			Ordine ordineNelModel = ordineService.save(ordineModel.getOrdine());
			
			for(ArticoloRequest a: ordineModel.getListaArticoliRichiesti()) {
				dettaglioOrdineService.save(a, ordineNelModel);
			}
			
			return ResponseEntity.status(HttpStatus.CREATED).body(ordineModel);
		}
		
		//cancella un ordine
		@RequestMapping(value = "/cancellaOrdine/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<String> deleteOrdine (
	    		@RequestHeader(value=AuthorityRolesConstants.HEADER_STRING) String jwtToken,
	    		@PathVariable Integer id
	    		) {
			
			Ordine ordineDaSostituire = ordineService.findById(id);
			for(DettaglioOrdine det: ordineDaSostituire.getDettaglioOrdini()) {
				dettaglioOrdineService.delete(det);
			}
			ordineService.delete(ordineDaSostituire);
			return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK);
		}
		//aggiorna un ordine preesistente
	
		@RequestMapping(value = "/updateOrdine/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<String> updateOrdine (
	    		@RequestHeader(value=AuthorityRolesConstants.HEADER_STRING) String jwtToken,
	    		@PathVariable Integer id,
	    		@RequestBody Ordine ordine
	    		) {
			
			Ordine oldOrdine = ordineService.findById(id);
			oldOrdine.setDettaglioOrdini(null);
			for(DettaglioOrdine det : ordine.getDettaglioOrdini()) {
				det.getIdDettaglioOrdine().setIdOrdine(id);
				dettaglioOrdineService.save(det);
			}
			oldOrdine.setDettaglioOrdini(ordine.getDettaglioOrdini());
			oldOrdine.setNomeCliente(ordine.getNomeCliente());
			oldOrdine.setData(ordine.getData());
			ordineService.save(oldOrdine);
			return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK);
		}
}
