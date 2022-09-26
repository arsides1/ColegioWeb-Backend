package colegio.com.service;



import colegio.com.model.Alumno;
import colegio.com.model.Nivel;

import java.util.List;

public interface AlumnoService {
	 

	List<Alumno> listarAlumno();

	public abstract void insert(Alumno alumno);

	public Alumno actualizarAlumno(Alumno alumno);
	public abstract void update(Alumno alumno);

	public abstract void delete(Long alumnoId);

	public abstract Alumno findById(Long alumnoId);

}
