package eu.winwinit.bcc.controllers;

import java.util.List;
import java.util.NoSuchElementException;
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
import eu.winwinit.bcc.entities.Articolo;
import eu.winwinit.bcc.service.ArticoloService;

@RestController
@RequestMapping("/articoli")
public class ArticoloController {
	
	@Autowired
	ArticoloService articoloService;
	
		
		 @RequestMapping(value = "/getAll", method = RequestMethod.GET)
		    public ResponseEntity<List<Articolo>> findAllArticoli() {
			 
			 List<Articolo> listaArticoli = articoloService.findAllArticoli();
		    	return new ResponseEntity<>(listaArticoli, HttpStatus.OK);
		    }
		 
		 @RequestMapping(value = "/getArticolo/{id}", method = RequestMethod.GET)
		 public ResponseEntity<Articolo> get(@PathVariable Integer id) {
			    try {
			        Articolo articolo = articoloService.get(id);
			        return new ResponseEntity<Articolo>(articolo, HttpStatus.OK);
			    } catch (NoSuchElementException e) {
			        return new ResponseEntity<Articolo>(HttpStatus.NOT_FOUND);
			    }      
			}
		 
		 
			 @RequestMapping(value = "/creaArticolo", method = RequestMethod.POST)       
			 public ResponseEntity<?> save(@RequestBody Articolo articolo) {
		           try {
					articoloService.save(articolo);
					
				} catch (NoSuchElementException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 return ResponseEntity.status(HttpStatus.CREATED).body(articolo);
			     }
		 
		 @RequestMapping(value = "/cancellaArticolo/{id}", method = RequestMethod.DELETE)
		   public ResponseEntity<Object> delete(@PathVariable("id") Integer id) { 
		      articoloService.remove(id);
		      return new ResponseEntity<>("Articolo cancellato", HttpStatus.OK);
		   }
		 
		 @RequestMapping(value="/updateArticolo/{id}",method=RequestMethod.PUT)
		 public ResponseEntity<?> update(
				 @RequestBody Articolo articolo,
				 @PathVariable Integer id) {
					     try {
					         Articolo existProduct = articoloService.findById(id);
					         existProduct.cambiaArticolo(articolo);
					         articoloService.save(existProduct);
					         return new ResponseEntity<>(HttpStatus.OK);
						     } 
					     catch (NoSuchElementException e) {
						         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		     }      
		 }
	
}
