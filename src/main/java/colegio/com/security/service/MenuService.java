package colegio.com.security.service;





import colegio.com.security.model.Menu;

import java.util.List;

public interface MenuService {

	List<Menu> listarMenuPorUsuario(String nombre);
	List<Menu> listarMenu();

	public abstract void insert(Menu menu);

	public abstract void update(Menu menu);

	public abstract void delete(Long menuId);

	public abstract Menu findById(Long menuId);

}
