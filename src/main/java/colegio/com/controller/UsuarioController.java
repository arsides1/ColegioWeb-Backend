package colegio.com.controller;

import colegio.com.model.Usuario;
import colegio.com.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@RestController
@RequestMapping("/Usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar()  {
        List<Usuario> usuarios = this.usuarioService.listarUsuario();


        return ResponseEntity.ok(usuarios);
		/*Collection<Usuario> usuario = usuarioService.findAll();
		return new ResponseEntity<>(usuario, HttpStatus.OK);*/
    }


    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable(name = "id") Long usuarioId) {
        Usuario usuario = usuarioService.findById(usuarioId);
        if (usuario == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro Usuario con ese id");
        }
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }


    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody Usuario usuario) {
        Map<String,String>respuesta = new HashMap<>();

        try {
            usuarioService.insert(usuario);
            respuesta.put("codigoRespuesta", "Ok");
            respuesta.put("msjRespuesta","Se creo Satisfactoriamente la nueva Usuario con codigo: " + usuario.getIdUsuario());
            respuesta.put("fechaCreacion", new Date(0).toString());
        }
        catch(Exception ex) {

            respuesta.put("CodigoRespuesta", "FAIL");
            respuesta.put("msjRespuesta","El Usuario ya se encuentra registrado");
        }
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }



   /* @PutMapping("/actualizar")
   //@RequestMapping(value = "/actualizar", method = { RequestMethod.GET, RequestMethod.PUT })
    public ResponseEntity<?> actualizar(@RequestBody Usuario usuario) {



        usuarioService.actualizarUsuario(usuario);

        Map<String,String>respuesta = new HashMap<>();


        try {
            usuarioService.actualizarUsuario(usuario);
            respuesta.put("codigoRespuesta", "Ok");
            respuesta.put("msjRespuesta","Se Actualizo el Usuario con codigo: " + usuario.getIdUsuario());
            respuesta.put("fechaCreacion", new Date(0).toString());
        }
        catch(Exception ex) {

            respuesta.put("CodigoRespuesta", "FAIL");
            respuesta.put("msjRespuesta","Ya se encuentra Usuariodo");
        }
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }


*/


 @PutMapping("/editar/{id}")
/*@RequestMapping(value = "/editar/{id}",
        produces = "application/json",
        method={ RequestMethod.GET, RequestMethod.PUT })*/
    //@RequestMapping(value = "/editar/{id}", method = {RequestMethod.PUT })
    public ResponseEntity<?> editar(@PathVariable(name = "id") Long idUsuario,
                                    @RequestBody Usuario usuario) {
        Usuario usuarioActual = usuarioService.findById(idUsuario);
//        if (usuarioActual != null) {
//            usuarioActual.setDescripcion(usuario.getDescripcion());
//            usuarioActual.setFechaInicio(usuario.getFechaInicio());
//            usuarioActual.setFechaFin(usuario.getFechaFin());
//            usuarioActual.setEstado(usuario.getEstado());
//            usuarioActual.setFechaRegistro(usuario.getFechaRegistro());
//            usuarioService.update(usuarioActual);
//            return new ResponseEntity<>(usuarioActual, HttpStatus.ACCEPTED);
//        }
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro usuario con ese id");

        //Usuario usuarioActual = usuarioService.findById(idUsuario);
        if (usuarioActual == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "No se pudo actualizar Usuario");
        this.usuarioService.update(usuario);
        Map<String,String>respuesta = new HashMap<>();
        respuesta.put("codigoRespuesta", "Ok");
        respuesta.put("msjRespuesta","Se Actualizo satisfactoriamente  Usuario con codigo: "+ String.valueOf(idUsuario));
        return new ResponseEntity<Object>(respuesta, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrar(@PathVariable Long id) {
        Usuario matriculaActual = usuarioService.findById(id);
        if (matriculaActual != null) {
            usuarioService.delete(id);
            return new ResponseEntity<>("Se borro correctamente", HttpStatus.ACCEPTED);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro matricula con ese id");

    }


}
