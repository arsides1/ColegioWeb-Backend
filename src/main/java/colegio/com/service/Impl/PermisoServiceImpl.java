package colegio.com.service.Impl;


import colegio.com.model.Permiso;
import colegio.com.repository.PermisoRepositoryJPA;
import colegio.com.service.PermisoService;
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
public class PermisoServiceImpl implements PermisoService {


	private final PermisoRepositoryJPA permisoRepo;



	@Override
	public List<Permiso> listarPermiso() {
		List<Permiso>permiso = StreamSupport.stream(
				this.permisoRepo.findAll().spliterator(),false).collect(Collectors.toList());
		return permiso;
	}

	@Override
	public void insert(Permiso permiso) {
		LocalDate fechaActual = LocalDate.now();
		permiso.setFechaRegistro(fechaActual);
		permisoRepo.save(permiso);
	}

	@Override
	public void update(Permiso permiso) {
		LocalDate fechaActual = LocalDate.now();
		permiso.setFechaRegistro(fechaActual);
		permisoRepo.save(permiso);
	}

	@Override
	public void delete(Long permisoId) {
		permisoRepo.deleteById(permisoId);
	}

	@Override
	public Permiso findById(Long permisoId) {
		return permisoRepo.findById(permisoId).orElse(null);
	}
}
