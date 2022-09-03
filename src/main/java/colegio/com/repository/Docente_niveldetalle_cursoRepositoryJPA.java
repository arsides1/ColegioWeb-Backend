package colegio.com.repository;


import colegio.com.model.Docente_niveldetalle_curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Docente_niveldetalle_cursoRepositoryJPA extends JpaRepository<Docente_niveldetalle_curso, Long>  {
	

	
}
