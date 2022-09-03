package colegio.com.repository;


import colegio.com.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepositoryJPA extends JpaRepository<Rol, Long>  {
	

	
}
