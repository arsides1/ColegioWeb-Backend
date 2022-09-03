package colegio.com.repository;


import colegio.com.model.SubMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubMenuRepositoryJPA extends JpaRepository<SubMenu, Long>  {
	

	
}
