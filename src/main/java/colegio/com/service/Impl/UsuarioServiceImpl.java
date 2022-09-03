package colegio.com.service.Impl;


import colegio.com.model.Usuario;
import colegio.com.repository.UsuarioRepositoryJPA;
import colegio.com.service.UsuarioService;
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
public class UsuarioServiceImpl implements UsuarioService {


	private final UsuarioRepositoryJPA usuarioRepo;



	@Override
	public List<Usuario> listarUsuario() {
		List<Usuario>usuario = StreamSupport.stream(
				this.usuarioRepo.findAll().spliterator(),false).collect(Collectors.toList());
		return usuario;
	}

	@Override
	public void insert(Usuario usuario) {
		LocalDate fechaActual = LocalDate.now();
		usuario.setFechaRegistro(fechaActual);
		usuarioRepo.save(usuario);
	}

	@Override
	public void update(Usuario usuario) {
		LocalDate fechaActual = LocalDate.now();
		usuario.setFechaRegistro(fechaActual);
		usuarioRepo.save(usuario);
	}

	@Override
	public void delete(Long usuarioId) {
		usuarioRepo.deleteById(usuarioId);
	}

	@Override
	public Usuario findById(Long usuarioId) {
		return usuarioRepo.findById(usuarioId).orElse(null);
	}
}
