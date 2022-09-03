package colegio.com.service;





import colegio.com.model.Usuario;

import java.util.List;

public interface UsuarioService {
	 

	List<Usuario> listarUsuario();

	public abstract void insert(Usuario usuario);

	public abstract void update(Usuario usuario);

	public abstract void delete(Long usuarioId);

	public abstract Usuario findById(Long usuarioId);

}
