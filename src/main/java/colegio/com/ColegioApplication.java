package colegio.com;

//import colegio.com.security.exception.UsuarioFoundException;
import colegio.com.security.model.Rol;
import colegio.com.security.model.Usuario;
import colegio.com.security.model.UsuarioRol;
import colegio.com.security.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
@RequiredArgsConstructor
public class ColegioApplication implements CommandLineRunner {

	private final UsuarioService usuarioService;
	public static void main(String[] args) {
		SpringApplication.run(ColegioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*try{
			Usuario usuario = new Usuario();

			usuario.setNombre("Arsides");
			usuario.setApellido("Ancajima");
			usuario.setUsername("arsides");
			usuario.setPassword("12345");
			usuario.setEmail("arsidesav@gmail.com");
			usuario.setTelefono("922499309");
			usuario.setPerfil("foto.png");


			Rol rol = new Rol();
			rol.setRolId(1L);
			rol.setRolNombre("ADMIN");

			Set<UsuarioRol> usuarioRoles = new HashSet<>();
			UsuarioRol usuarioRol = new UsuarioRol();
			usuarioRol.setRol(rol);
			usuarioRol.setUsuario(usuario);
			usuarioRoles.add(usuarioRol);

			Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario,usuarioRoles);
			System.out.println(usuarioGuardado.getUsername());

		}catch(UsuarioFoundException exception){
			exception.printStackTrace();
		}*/

	}
}
