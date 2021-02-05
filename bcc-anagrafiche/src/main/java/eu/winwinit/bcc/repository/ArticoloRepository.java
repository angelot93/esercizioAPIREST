package eu.winwinit.bcc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eu.winwinit.bcc.entities.Articolo;

@Repository("articoloRepository")
public interface ArticoloRepository extends JpaRepository<Articolo, Integer> {

	List<Articolo> findByTipo(String tipo);

	
	


}
