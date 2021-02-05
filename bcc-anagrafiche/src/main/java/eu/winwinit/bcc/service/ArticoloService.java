package eu.winwinit.bcc.service;

import java.util.List;

import eu.winwinit.bcc.entities.Articolo;

public interface ArticoloService {

	
	public List<Articolo> findByTipo(String tipo);
	
	public List<Articolo> findAllArticoli();

	public void save(Articolo articolo);

	public void remove(Integer id);

	public Articolo get(Integer id);

	public Articolo findById(Integer id);
	
}
