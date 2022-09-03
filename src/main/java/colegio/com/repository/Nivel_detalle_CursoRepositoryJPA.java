package colegio.com.repository;

import colegio.com.model.Nivel_detalle_Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Nivel_detalle_CursoRepositoryJPA extends JpaRepository<Nivel_detalle_Curso, Long>  {
	

	
}
