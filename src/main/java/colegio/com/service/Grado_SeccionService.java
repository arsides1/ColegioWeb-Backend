package colegio.com.service;





import colegio.com.model.Grado_Seccion;
import colegio.com.model.Periodo;

import java.util.List;

public interface Grado_SeccionService {
	 

	List<Grado_Seccion> listarGrado_Seccion();

	public abstract void insert(Grado_Seccion grado_Seccion);

	public abstract void update(Grado_Seccion grado_Seccion);

	public Grado_Seccion actualizarGrado_Seccion(Grado_Seccion grado_Seccion);

	public abstract void delete(Long grado_SeccionId);

	public abstract Grado_Seccion findById(Long grado_SeccionId);

}
