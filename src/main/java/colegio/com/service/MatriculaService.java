package colegio.com.service;



import colegio.com.model.Matricula;
import colegio.com.model.Periodo;

import java.util.List;


public interface MatriculaService {
	 


	public abstract void insert(Matricula matricula);

	public Matricula actualizarMatricula(Matricula matricula);

	public abstract void update(Matricula matricula);

	public abstract void delete(Long matriculaId);

	public abstract Matricula findById(Long matriculaId);
	
	 List<Matricula> listarMatricula();


}
