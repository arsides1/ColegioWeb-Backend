package colegio.com.service;





import colegio.com.model.Rol;

import java.util.List;

public interface RolService {
	 

	List<Rol> listarRol();

	public abstract void insert(Rol rol);

	public abstract void update(Rol rol);

	public abstract void delete(Long rolId);

	public abstract Rol findById(Long rolId);

}
