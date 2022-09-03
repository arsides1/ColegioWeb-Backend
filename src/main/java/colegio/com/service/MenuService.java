package colegio.com.service;





import colegio.com.model.Menu;

import java.util.List;

public interface MenuService {
	 

	List<Menu> listarMenu();

	public abstract void insert(Menu menu);

	public abstract void update(Menu menu);

	public abstract void delete(Long menuId);

	public abstract Menu findById(Long menuId);

}
