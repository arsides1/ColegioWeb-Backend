package colegio.com;

/*import colegio.com.security.exception.UsuarioFoundException;
import colegio.com.security.model.Rol;
import colegio.com.security.model.Usuario;
import colegio.com.security.model.UsuarioRol;*/
import colegio.com.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;


@SpringBootApplication

public class ColegioApplication implements CommandLineRunner {
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ColegioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*try{
			Usuario usuario = new Usuario();

			usuario.setNombre("luis");
			usuario.setApellido("valencia");
			usuario.setUsername("luis");
			usuario.setPassword(bCryptPasswordEncoder.encode("12345"));
			usuario.setEmail("luisav@gmail.com");
			usuario.setTelefono("922499309");
			usuario.setPerfil("foto.png");


			Rol rol = new Rol();

			rol.setRolNombre("ALUMNO");

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
