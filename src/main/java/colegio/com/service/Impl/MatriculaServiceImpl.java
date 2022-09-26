package colegio.com.service.Impl;

import colegio.com.model.Matricula;
import colegio.com.repository.MatriculaRepositoryJPA;
import colegio.com.service.MatriculaService;
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
public class MatriculaServiceImpl implements MatriculaService {

    private final MatriculaRepositoryJPA matriculaRepo;


	@Override
	public void insert(Matricula matricula) {
		LocalDate fechaActual = LocalDate.now();
		matricula.setFechaRegistro(fechaActual);
		 matriculaRepo.save(matricula);
		
	}

	@Override
	public Matricula actualizarMatricula(Matricula matricula) {
		LocalDate fechaActual = LocalDate.now();
		matricula.setFechaRegistro(fechaActual);
		//periodo.setEstado(false);
	/*	if( !periodo.getEstado()){
			periodo.setEstado(true);
		}
		if(null == periodo.getEstado()) {
			periodo.setEstado(false);
		}
*/
		return matriculaRepo.save(matricula);
	}

	@Override
	public void update(Matricula matricula) {
		LocalDate fechaActual = LocalDate.now();
		matricula.setFechaRegistro(fechaActual);
		matriculaRepo.save(matricula);
	}
	@Override
	public void delete(Long matriculaId) {
		 matriculaRepo.deleteById(matriculaId);
		
	}
	@Override
	public Matricula findById(Long matriculaId) {
		return matriculaRepo.findById(matriculaId).orElse(null);
	
	}


	@Override
	public List<Matricula> listarMatricula() {
		List<Matricula>matriculas = StreamSupport.stream(
				this.matriculaRepo.findAll().spliterator(),false).collect(Collectors.toList());
		return matriculas;
	}
    


}
