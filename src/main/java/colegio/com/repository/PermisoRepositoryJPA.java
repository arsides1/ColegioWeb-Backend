package colegio.com.repository;


import colegio.com.model.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermisoRepositoryJPA extends JpaRepository<Permiso, Long>  {
	

	
}
