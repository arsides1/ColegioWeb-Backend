package colegio.com.service.Impl;


import colegio.com.model.Rol;
import colegio.com.repository.RolRepositoryJPA;
import colegio.com.service.RolService;
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
public class RolServiceImpl implements RolService {


	private final RolRepositoryJPA rolRepo;



	@Override
	public List<Rol> listarRol() {
		List<Rol>rol = StreamSupport.stream(
				this.rolRepo.findAll().spliterator(),false).collect(Collectors.toList());
		return rol;
	}

	@Override
	public void insert(Rol rol) {
		LocalDate fechaActual = LocalDate.now();
		rol.setFechaRegistro(fechaActual);
		rolRepo.save(rol);
	}

	@Override
	public void update(Rol rol) {
		LocalDate fechaActual = LocalDate.now();
		rol.setFechaRegistro(fechaActual);
		rolRepo.save(rol);
	}

	@Override
	public void delete(Long rolId) {
		rolRepo.deleteById(rolId);
	}

	@Override
	public Rol findById(Long rolId) {
		return rolRepo.findById(rolId).orElse(null);
	}
}
