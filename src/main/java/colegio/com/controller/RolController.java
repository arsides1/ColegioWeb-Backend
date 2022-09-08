package colegio.com.controller;

import colegio.com.model.Rol;
import colegio.com.service.RolService;
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
@RequestMapping("/Rol")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RolController {

    private final RolService rolService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar()  {
        List<Rol> rols = this.rolService.listarRol();


        return ResponseEntity.ok(rols);
		/*Collection<Rol> rol = rolService.findAll();
		return new ResponseEntity<>(rol, HttpStatus.OK);*/
    }


    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable(name = "id") Long rolId) {
        Rol rol = rolService.findById(rolId);
        if (rol == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro Rol con ese id");
        }
        return new ResponseEntity<>(rol, HttpStatus.OK);
    }


    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody Rol rol) {
        Map<String,String>respuesta = new HashMap<>();

        try {
            rolService.insert(rol);
            respuesta.put("codigoRespuesta", "Ok");
            respuesta.put("msjRespuesta","Se creo Satisfactoriamente la nueva Rol con codigo: " + rol.getIdRol());
            respuesta.put("fechaCreacion", new Date(0).toString());
        }
        catch(Exception ex) {

            respuesta.put("CodigoRespuesta", "FAIL");
            respuesta.put("msjRespuesta","El Rol ya se encuentra registrado");
        }
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }



   /* @PutMapping("/actualizar")
   //@RequestMapping(value = "/actualizar", method = { RequestMethod.GET, RequestMethod.PUT })
    public ResponseEntity<?> actualizar(@RequestBody Rol rol) {



        rolService.actualizarRol(rol);

        Map<String,String>respuesta = new HashMap<>();


        try {
            rolService.actualizarRol(rol);
            respuesta.put("codigoRespuesta", "Ok");
            respuesta.put("msjRespuesta","Se Actualizo  Rol con codigo: " + rol.getIdRol());
            respuesta.put("fechaCreacion", new Date(0).toString());
        }
        catch(Exception ex) {

            respuesta.put("CodigoRespuesta", "FAIL");
            respuesta.put("msjRespuesta","Ya se encuentra Roldo");
        }
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }


*/


 @PutMapping("/editar/{id}")
/*@RequestMapping(value = "/editar/{id}",
        produces = "application/json",
        method={ RequestMethod.GET, RequestMethod.PUT })*/
    //@RequestMapping(value = "/editar/{id}", method = {RequestMethod.PUT })
    public ResponseEntity<?> editar(@PathVariable(name = "id") Long idRol,
                                    @RequestBody Rol rol) {
        Rol rolActual = rolService.findById(idRol);
//        if (rolActual != null) {
//            rolActual.setDescripcion(rol.getDescripcion());
//            rolActual.setFechaInicio(rol.getFechaInicio());
//            rolActual.setFechaFin(rol.getFechaFin());
//            rolActual.setEstado(rol.getEstado());
//            rolActual.setFechaRegistro(rol.getFechaRegistro());
//            rolService.update(rolActual);
//            return new ResponseEntity<>(rolActual, HttpStatus.ACCEPTED);
//        }
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro rol con ese id");

        //Rol rolActual = rolService.findById(idRol);
        if (rolActual == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "No se pudo actualizar Rol");
        this.rolService.update(rol);
        Map<String,String>respuesta = new HashMap<>();
        respuesta.put("codigoRespuesta", "Ok");
        respuesta.put("msjRespuesta","Se Actualizo satisfactoriamente los datos del Rol con codigo: "+ String.valueOf(idRol));
        return new ResponseEntity<Object>(respuesta, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrar(@PathVariable Long id) {
        Rol matriculaActual = rolService.findById(id);
        if (matriculaActual != null) {
            rolService.delete(id);
            return new ResponseEntity<>("Se borro correctamente", HttpStatus.ACCEPTED);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro matricula con ese id");

    }


}
