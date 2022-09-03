package colegio.com.service;




import colegio.com.model.Asistencia;

import java.util.List;

public interface AsistenciaService {
	 

	List<Asistencia> listarAsistencia();

	public abstract void insert(Asistencia asistencia);

	public abstract void update(Asistencia asistencia);

	public abstract void delete(Long asistenciaId);

	public abstract Asistencia findById(Long asistenciaId);

}
