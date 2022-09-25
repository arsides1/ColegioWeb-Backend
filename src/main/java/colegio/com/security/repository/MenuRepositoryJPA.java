package colegio.com.security.repository;



import colegio.com.security.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepositoryJPA extends JpaRepository<Menu, Long>  {
    @Query(value="SELECT a.id_menu,a.estado,a.fecha_registro,a.icono,a.nombre,a.url FROM menu a INNER JOIN menu_rol c ON c.menu_id_menu = a.id_menu INNER JOIN roles b ON c.rol_rol_id = b.rol_id INNER JOIN usuario_rol d ON d.rol_rol_id = b.rol_id INNER JOIN usuarios e ON e.id = d.usuario_id where e.username= :nombre", nativeQuery = true)
    List<Object[]> listarMenuPorUsuario(@Param("nombre") String nombre);
	
}
