package colegio.com.repository;


import colegio.com.model.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NivelRepositoryJPA extends JpaRepository<Nivel, Long>  {
	

	
}
