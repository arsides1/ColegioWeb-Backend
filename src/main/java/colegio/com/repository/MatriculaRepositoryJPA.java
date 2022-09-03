package colegio.com.repository;


import colegio.com.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepositoryJPA extends JpaRepository<Matricula, Long>  {
	

	
}
