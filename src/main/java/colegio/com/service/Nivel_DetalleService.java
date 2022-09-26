package colegio.com.service;





import colegio.com.model.Alumno;
import colegio.com.model.Nivel_Detalle;

import java.util.List;

public interface Nivel_DetalleService {
	 

	List<Nivel_Detalle> listarNivel_Detalle();

	public abstract void insert(Nivel_Detalle nivel_Detalle);

	public Nivel_Detalle actualizarNivel_Detalle(Nivel_Detalle nivel_Detalle);
	public abstract void update(Nivel_Detalle nivel_Detalle);

	public abstract void delete(Long nivel_DetalleId);

	public abstract Nivel_Detalle findById(Long nivel_DetalleId);

}
