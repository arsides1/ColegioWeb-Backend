package colegio.com.service.Impl;


import colegio.com.model.Curricula;
import colegio.com.repository.CurriculaRepositoryJPA;
import colegio.com.service.CurriculaService;
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
public class CurriculaServiceImpl implements CurriculaService {


	private final CurriculaRepositoryJPA curriculaRepo;



	@Override
	public List<Curricula> listarCurricula() {
		List<Curricula>curricula = StreamSupport.stream(
				this.curriculaRepo.findAll().spliterator(),false).collect(Collectors.toList());
		return curricula;
	}

	@Override
	public void insert(Curricula curricula) {
		LocalDate fechaActual = LocalDate.now();
		curricula.setFechaRegistro(fechaActual);
		curriculaRepo.save(curricula);
	}

	@Override
	public void update(Curricula curricula) {
		LocalDate fechaActual = LocalDate.now();
		curricula.setFechaRegistro(fechaActual);
		curriculaRepo.save(curricula);
	}

	@Override
	public void delete(Long curriculaId) {
		curriculaRepo.deleteById(curriculaId);
	}

	@Override
	public Curricula findById(Long curriculaId) {
		return curriculaRepo.findById(curriculaId).orElse(null);
	}
}
