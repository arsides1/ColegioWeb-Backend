package colegio.com.service.Impl;


import colegio.com.model.PagoMatricula;
import colegio.com.repository.PagoMatriculaRepositoryJPA;
import colegio.com.service.PagoMatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Transactional
public class PagoMatriculaServiceImpl implements PagoMatriculaService {


	private final PagoMatriculaRepositoryJPA pagoMatriculaRepo;



	@Override
	public List<PagoMatricula> listarPagoMatricula() {
		List<PagoMatricula>pagoMatricula = StreamSupport.stream(
				this.pagoMatriculaRepo.findAll().spliterator(),false).collect(Collectors.toList());
		return pagoMatricula;
	}

	@Override
	public void insert(PagoMatricula pagoMatricula) {
		LocalDate fechaActual = LocalDate.now();
		pagoMatricula.setFechaRegistro(fechaActual);
		pagoMatriculaRepo.save(pagoMatricula);
	}

	@Override
	public void update(PagoMatricula pagoMatricula) {
		LocalDate fechaActual = LocalDate.now();
		pagoMatricula.setFechaRegistro(fechaActual);
		pagoMatriculaRepo.save(pagoMatricula);
	}

	@Override
	public void delete(Long pagoMatriculaId) {
		pagoMatriculaRepo.deleteById(pagoMatriculaId);
	}

	@Override
	public PagoMatricula findById(Long pagoMatriculaId) {
		return pagoMatriculaRepo.findById(pagoMatriculaId).orElse(null);
	}
}
