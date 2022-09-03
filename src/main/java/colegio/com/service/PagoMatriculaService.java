package colegio.com.service;





import colegio.com.model.PagoMatricula;

import java.util.List;

public interface PagoMatriculaService {
	 

	List<PagoMatricula> listarPagoMatricula();

	public abstract void insert(PagoMatricula pagoMatricula);

	public abstract void update(PagoMatricula pagoMatricula);

	public abstract void delete(Long pagoMatriculaId);

	public abstract PagoMatricula findById(Long pagoMatriculaId);

}
