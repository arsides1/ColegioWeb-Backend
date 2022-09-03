package colegio.com.repository;


import colegio.com.model.Nivel_Detalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Nivel_DetalleRepositoryJPA extends JpaRepository<Nivel_Detalle, Long>  {
	

	
}
