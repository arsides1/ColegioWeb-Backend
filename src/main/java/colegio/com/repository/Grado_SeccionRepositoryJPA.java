package colegio.com.repository;

import colegio.com.model.Grado_Seccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Grado_SeccionRepositoryJPA extends JpaRepository<Grado_Seccion, Long>  {
	

	
}
