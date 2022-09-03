package colegio.com.service;



import colegio.com.model.Alumno;
import colegio.com.model.Apoderado;

import java.util.List;

public interface ApoderadoService {
	 

	List<Apoderado> listarApoderado();

	public abstract void insert(Apoderado apoderado);

	public abstract void update(Apoderado apoderado);

	public abstract void delete(Long apoderadoId);

	public abstract Apoderado findById(Long apoderadoId);

}
