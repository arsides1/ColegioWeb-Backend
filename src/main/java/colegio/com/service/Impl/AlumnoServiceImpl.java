package colegio.com.service.Impl;


import colegio.com.model.Alumno;
import colegio.com.repository.AlumnoRepositoryJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import colegio.com.service.AlumnoService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Transactional
public class AlumnoServiceImpl implements AlumnoService {


	private final AlumnoRepositoryJPA alumnoRepo;



	@Override
	public List<Alumno> listarAlumno() {
		List<Alumno>alumno = StreamSupport.stream(
				this.alumnoRepo.findAll().spliterator(),false).collect(Collectors.toList());
		return alumno;
	}

	@Override
	public void insert(Alumno alumno) {
		LocalDate fechaActual = LocalDate.now();
		alumno.setFechaRegistro(fechaActual);
		alumnoRepo.save(alumno);
	}

	@Override
	public void update(Alumno alumno) {
		LocalDate fechaActual = LocalDate.now();
		alumno.setFechaRegistro(fechaActual);
		alumnoRepo.save(alumno);
	}

	@Override
	public void delete(Long alumnoId) {
		alumnoRepo.deleteById(alumnoId);
	}

	@Override
	public Alumno findById(Long alumnoId) {
		return alumnoRepo.findById(alumnoId).orElse(null);
	}
}
