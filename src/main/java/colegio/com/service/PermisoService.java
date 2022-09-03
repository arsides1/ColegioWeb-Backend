package colegio.com.service;





import colegio.com.model.Permiso;

import java.util.List;

public interface PermisoService {
	 

	List<Permiso> listarPermiso();

	public abstract void insert(Permiso permiso);

	public abstract void update(Permiso permiso);

	public abstract void delete(Long permisoId);

	public abstract Permiso findById(Long permisoId);

}
