package colegio.com.repository;


import colegio.com.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositoryJPA extends JpaRepository<Usuario, Long>  {
	

	
}
