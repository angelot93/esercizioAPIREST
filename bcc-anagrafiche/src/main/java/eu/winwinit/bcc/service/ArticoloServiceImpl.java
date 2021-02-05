package eu.winwinit.bcc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.winwinit.bcc.entities.Articolo;
import eu.winwinit.bcc.repository.ArticoloRepository;

@Service("articoloService")
public class ArticoloServiceImpl implements ArticoloService {

	@Autowired
	private ArticoloRepository articoloRepository;
	
	
	public Articolo findById(Integer id) {
		// TODO Auto-generated method stub
		return articoloRepository.findById(id).get();
	}

	public List<Articolo> findByTipo(String tipo) {
		// TODO Auto-generated method stub
		return articoloRepository.findByTipo(tipo);
	}

	@Override
	public List<Articolo> findAllArticoli() {
		
		return articoloRepository.findAll();
	}

	@Override
	public void save(Articolo articolo) {
		articoloRepository.save(articolo);
		
	}

	@Override
	public void remove(Integer id) {
		articoloRepository.deleteById(id);
		
	}

	@Override
	public Articolo get(Integer id) {
		// TODO Auto-generated method stub
		return articoloRepository.getOne(id);
	}

}
