package colegio.com.service;





import colegio.com.model.Periodo;

import java.util.List;

public interface PeriodoService {
	 

	List<Periodo> listarPeriodo();

	public abstract void insert(Periodo periodo);

	public Periodo actualizarPeriodo(Periodo periodo);

	public abstract void update(Periodo periodo);

	public abstract void delete(Long periodoId);

	public abstract Periodo findById(Long periodoId);

}
