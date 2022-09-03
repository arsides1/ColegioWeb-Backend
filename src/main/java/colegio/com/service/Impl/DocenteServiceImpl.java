package colegio.com.service.Impl;


import colegio.com.model.Docente;
import colegio.com.repository.DocenteRepositoryJPA;
import colegio.com.service.DocenteService;
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
public class DocenteServiceImpl implements DocenteService {


	private final DocenteRepositoryJPA docenteRepo;



	@Override
	public List<Docente> listarDocente() {
		List<Docente>docente = StreamSupport.stream(
				this.docenteRepo.findAll().spliterator(),false).collect(Collectors.toList());
		return docente;
	}

	@Override
	public void insert(Docente docente) {
		LocalDate fechaActual = LocalDate.now();
		docente.setFechaRegistro(fechaActual);
		docenteRepo.save(docente);
	}

	@Override
	public void update(Docente docente) {
		LocalDate fechaActual = LocalDate.now();
		docente.setFechaRegistro(fechaActual);
		docenteRepo.save(docente);
	}

	@Override
	public void delete(Long docenteId) {
		docenteRepo.deleteById(docenteId);
	}

	@Override
	public Docente findById(Long docenteId) {
		return docenteRepo.findById(docenteId).orElse(null);
	}
}
