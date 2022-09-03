package colegio.com.service.Impl;


import colegio.com.model.Docente_niveldetalle_curso;
import colegio.com.repository.Docente_niveldetalle_cursoRepositoryJPA;
import colegio.com.service.Docente_niveldetalle_cursoService;
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
public class Docente_niveldetalle_cursoServiceImpl implements Docente_niveldetalle_cursoService {


	private final Docente_niveldetalle_cursoRepositoryJPA docente_niveldetalle_cursoRepo;



	@Override
	public List<Docente_niveldetalle_curso> listarDocente_niveldetalle_curso() {
		List<Docente_niveldetalle_curso>docente_niveldetalle_curso = StreamSupport.stream(
				this.docente_niveldetalle_cursoRepo.findAll().spliterator(),false).collect(Collectors.toList());
		return docente_niveldetalle_curso;
	}

	@Override
	public void insert(Docente_niveldetalle_curso docente_niveldetalle_curso) {
		LocalDate fechaActual = LocalDate.now();
		docente_niveldetalle_curso.setFechaRegistro(fechaActual);
		docente_niveldetalle_cursoRepo.save(docente_niveldetalle_curso);
	}

	@Override
	public void update(Docente_niveldetalle_curso docente_niveldetalle_curso) {
		LocalDate fechaActual = LocalDate.now();
		docente_niveldetalle_curso.setFechaRegistro(fechaActual);
		docente_niveldetalle_cursoRepo.save(docente_niveldetalle_curso);
	}

	@Override
	public void delete(Long docente_niveldetalle_cursoId) {
		docente_niveldetalle_cursoRepo.deleteById(docente_niveldetalle_cursoId);
	}

	@Override
	public Docente_niveldetalle_curso findById(Long docente_niveldetalle_cursoId) {
		return docente_niveldetalle_cursoRepo.findById(docente_niveldetalle_cursoId).orElse(null);
	}
}
