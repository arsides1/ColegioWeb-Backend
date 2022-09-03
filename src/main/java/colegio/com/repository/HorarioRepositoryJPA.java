package colegio.com.repository;


import colegio.com.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepositoryJPA extends JpaRepository<Horario, Long>  {
	

	
}
