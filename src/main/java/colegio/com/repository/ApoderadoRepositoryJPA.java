package colegio.com.repository;



import colegio.com.model.Apoderado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApoderadoRepositoryJPA extends JpaRepository<Apoderado, Long>  {
	

	
}
