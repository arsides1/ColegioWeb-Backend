package colegio.com.repository;



import colegio.com.model.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsistenciaRepositoryJPA extends JpaRepository<Asistencia, Long>  {
	

	
}
