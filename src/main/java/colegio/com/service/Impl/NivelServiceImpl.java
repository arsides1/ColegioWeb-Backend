package colegio.com.service.Impl;


import colegio.com.model.Nivel;
import colegio.com.repository.NivelRepositoryJPA;
import colegio.com.service.NivelService;
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
public class NivelServiceImpl implements NivelService {


	private final NivelRepositoryJPA nivelRepo;



	@Override
	public List<Nivel> listarNivel() {
		List<Nivel>nivel = StreamSupport.stream(
				this.nivelRepo.findAll().spliterator(),false).collect(Collectors.toList());
		return nivel;
	}

	@Override
	public void insert(Nivel nivel) {
		LocalDate fechaActual = LocalDate.now();
		nivel.setFechaRegistro(fechaActual);
		nivelRepo.save(nivel);
	}

	@Override
	public void update(Nivel nivel) {
		LocalDate fechaActual = LocalDate.now();
		nivel.setFechaRegistro(fechaActual);
		nivelRepo.save(nivel);
	}

	@Override
	public void delete(Long nivelId) {
		nivelRepo.deleteById(nivelId);
	}

	@Override
	public Nivel findById(Long nivelId) {
		return nivelRepo.findById(nivelId).orElse(null);
	}
}
