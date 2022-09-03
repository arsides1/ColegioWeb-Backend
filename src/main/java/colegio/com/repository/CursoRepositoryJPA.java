package colegio.com.repository;

import colegio.com.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CursoRepositoryJPA extends JpaRepository<Curso, Long>  {
	

	
}
