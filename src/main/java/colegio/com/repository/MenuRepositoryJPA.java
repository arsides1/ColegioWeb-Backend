package colegio.com.repository;



import colegio.com.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepositoryJPA extends JpaRepository<Menu, Long>  {
	

	
}
