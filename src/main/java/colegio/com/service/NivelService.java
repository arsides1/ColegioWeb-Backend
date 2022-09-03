package colegio.com.service;





import colegio.com.model.Nivel;

import java.util.List;

public interface NivelService {
	 

	List<Nivel> listarNivel();

	public abstract void insert(Nivel nivel);

	public abstract void update(Nivel nivel);

	public abstract void delete(Long nivelId);

	public abstract Nivel findById(Long nivelId);

}
