package colegio.com.repository;




import colegio.com.model.Curricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurriculaRepositoryJPA extends JpaRepository<Curricula, Long>  {
	

	
}
