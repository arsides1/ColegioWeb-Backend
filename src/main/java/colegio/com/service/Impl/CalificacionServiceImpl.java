package colegio.com.service.Impl;


import colegio.com.model.Calificacion;
import colegio.com.repository.CalificacionRepositoryJPA;
import colegio.com.service.CalificacionService;
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
public class CalificacionServiceImpl implements CalificacionService {


	private final CalificacionRepositoryJPA calificacionRepo;



	@Override
	public List<Calificacion> listarCalificacion() {
		List<Calificacion>calificacion = StreamSupport.stream(
				this.calificacionRepo.findAll().spliterator(),false).collect(Collectors.toList());
		return calificacion;
	}

	@Override
	public void insert(Calificacion calificacion) {
		LocalDate fechaActual = LocalDate.now();
		calificacion.setFechaRegistro(fechaActual);
		calificacionRepo.save(calificacion);
	}

	@Override
	public void update(Calificacion calificacion) {
		LocalDate fechaActual = LocalDate.now();
		calificacion.setFechaRegistro(fechaActual);
		calificacionRepo.save(calificacion);
	}

	@Override
	public void delete(Long calificacionId) {
		calificacionRepo.deleteById(calificacionId);
	}

	@Override
	public Calificacion findById(Long calificacionId) {
		return calificacionRepo.findById(calificacionId).orElse(null);
	}
}
