package colegio.com.service.Impl;


import colegio.com.model.Asistencia;
import colegio.com.repository.AsistenciaRepositoryJPA;
import colegio.com.service.AsistenciaService;
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
public class AsistenciaServiceImpl implements AsistenciaService {


	private final AsistenciaRepositoryJPA asistenciaRepo;



	@Override
	public List<Asistencia> listarAsistencia() {
		List<Asistencia>asistencia = StreamSupport.stream(
				this.asistenciaRepo.findAll().spliterator(),false).collect(Collectors.toList());
		return asistencia;
	}

	@Override
	public void insert(Asistencia asistencia) {
		LocalDate fechaActual = LocalDate.now();
		asistencia.setFechaIngreso(fechaActual);
		asistenciaRepo.save(asistencia);
	}

	@Override
	public void update(Asistencia asistencia) {
		LocalDate fechaActual = LocalDate.now();
		asistencia.setFechaIngreso(fechaActual);
		asistenciaRepo.save(asistencia);
	}

	@Override
	public void delete(Long asistenciaId) {
		asistenciaRepo.deleteById(asistenciaId);
	}

	@Override
	public Asistencia findById(Long asistenciaId) {
		return asistenciaRepo.findById(asistenciaId).orElse(null);
	}
}
