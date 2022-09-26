package colegio.com.security.controller;


import colegio.com.security.model.Menu;
import colegio.com.security.model.Rol;
import colegio.com.security.model.Usuario;
import colegio.com.security.model.UsuarioRol;
import colegio.com.security.service.MenuService;
import colegio.com.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/usuarios")
//@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MenuService service;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/agregar")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception{
        usuario.setPerfil("default.png");

        usuario.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));

        Set<UsuarioRol> usuarioRoles = new HashSet<>();

        Rol rol = new Rol();
        rol.setRolNombre(rol.getRolNombre());

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);

        usuarioRoles.add(usuarioRol);
        return usuarioService.guardarUsuario(usuario,usuarioRoles);
    }


    @GetMapping("/list/{username}")
    public Usuario obtenerUsuario(@PathVariable("username") String username){
        return usuarioService.obtenerUsuario(username);
    }

    @DeleteMapping("/del/{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId){
        usuarioService.eliminarUsuario(usuarioId);
    }
    @GetMapping(value = "/usuarioos/{nombre}")
    public ResponseEntity<?> listar(@PathVariable("nombre") String nombre) {
        List<Menu> menus = service.listarMenuPorUsuario(nombre);
        return ResponseEntity.ok(menus);
    }


}
