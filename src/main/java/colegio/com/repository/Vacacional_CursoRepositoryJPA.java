package colegio.com.repository;



import colegio.com.model.Vacacional_Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Vacacional_CursoRepositoryJPA extends JpaRepository<Vacacional_Curso, Long>  {
	

	
}
