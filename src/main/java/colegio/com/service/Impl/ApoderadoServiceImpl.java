package colegio.com.service.Impl;


import colegio.com.model.Apoderado;
import colegio.com.repository.ApoderadoRepositoryJPA;
import colegio.com.service.ApoderadoService;
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
public class ApoderadoServiceImpl implements ApoderadoService {


	private final ApoderadoRepositoryJPA apoderadoRepo;



	@Override
	public List<Apoderado> listarApoderado() {
		List<Apoderado>apoderado = StreamSupport.stream(
				this.apoderadoRepo.findAll().spliterator(),false).collect(Collectors.toList());
		return apoderado;
	}

	@Override
	public void insert(Apoderado apoderado) {
		LocalDate fechaActual = LocalDate.now();
		apoderado.setFechaRegistro(fechaActual);
		apoderadoRepo.save(apoderado);
	}

	@Override
	public void update(Apoderado apoderado) {
		LocalDate fechaActual = LocalDate.now();
		apoderado.setFechaRegistro(fechaActual);
		apoderadoRepo.save(apoderado);
	}

	@Override
	public void delete(Long apoderadoId) {
		apoderadoRepo.deleteById(apoderadoId);
	}

	@Override
	public Apoderado findById(Long apoderadoId) {
		return apoderadoRepo.findById(apoderadoId).orElse(null);
	}
}
