package colegio.com.service;





import colegio.com.model.SubMenu;

import java.util.List;

public interface SubMenuService {
	 

	List<SubMenu> listarSubMenu();

	public abstract void insert(SubMenu subMenu);

	public abstract void update(SubMenu subMenu);

	public abstract void delete(Long subMenuId);

	public abstract SubMenu findById(Long subMenuId);

}
