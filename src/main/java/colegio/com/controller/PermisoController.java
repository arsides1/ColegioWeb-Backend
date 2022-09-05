package colegio.com.controller;

import colegio.com.model.Permiso;
import colegio.com.service.PermisoService;
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
@RequestMapping("/Permiso")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PermisoController {

    private final PermisoService permisoService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar()  {
        List<Permiso> permisos = this.permisoService.listarPermiso();


        return ResponseEntity.ok(permisos);
		/*Collection<Permiso> permiso = permisoService.findAll();
		return new ResponseEntity<>(permiso, HttpStatus.OK);*/
    }


    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable(name = "id") Long permisoId) {
        Permiso permiso = permisoService.findById(permisoId);
        if (permiso == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro Permiso con ese id");
        }
        return new ResponseEntity<>(permiso, HttpStatus.OK);
    }


    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody Permiso permiso) {
        Map<String,String>respuesta = new HashMap<>();

        try {
            permisoService.insert(permiso);
            respuesta.put("codigoRespuesta", "Ok");
            respuesta.put("msjRespuesta","Se creo Satisfactoriamente la nueva Permiso con codigo: " + permiso.getIdPermiso());
            respuesta.put("fechaCreacion", new Date(0).toString());
        }
        catch(Exception ex) {

            respuesta.put("CodigoRespuesta", "FAIL");
            respuesta.put("msjRespuesta","El Permiso ya se encuentra registrado");
        }
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }



   /* @PutMapping("/actualizar")
   //@RequestMapping(value = "/actualizar", method = { RequestMethod.GET, RequestMethod.PUT })
    public ResponseEntity<?> actualizar(@RequestBody Permiso permiso) {



        permisoService.actualizarPermiso(permiso);

        Map<String,String>respuesta = new HashMap<>();


        try {
            permisoService.actualizarPermiso(permiso);
            respuesta.put("codigoRespuesta", "Ok");
            respuesta.put("msjRespuesta","Se Actualizo  Permiso con codigo: " + permiso.getIdPermiso());
            respuesta.put("fechaCreacion", new Date(0).toString());
        }
        catch(Exception ex) {

            respuesta.put("CodigoRespuesta", "FAIL");
            respuesta.put("msjRespuesta","Ya se encuentra Permisodo");
        }
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }


*/


 @PutMapping("/editar/{id}")
/*@RequestMapping(value = "/editar/{id}",
        produces = "application/json",
        method={ RequestMethod.GET, RequestMethod.PUT })*/
    //@RequestMapping(value = "/editar/{id}", method = {RequestMethod.PUT })
    public ResponseEntity<?> editar(@PathVariable(name = "id") Long idPermiso,
                                    @RequestBody Permiso permiso) {
        Permiso permisoActual = permisoService.findById(idPermiso);
//        if (permisoActual != null) {
//            permisoActual.setDescripcion(permiso.getDescripcion());
//            permisoActual.setFechaInicio(permiso.getFechaInicio());
//            permisoActual.setFechaFin(permiso.getFechaFin());
//            permisoActual.setEstado(permiso.getEstado());
//            permisoActual.setFechaRegistro(permiso.getFechaRegistro());
//            permisoService.update(permisoActual);
//            return new ResponseEntity<>(permisoActual, HttpStatus.ACCEPTED);
//        }
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro permiso con ese id");

        //Permiso permisoActual = permisoService.findById(idPermiso);
        if (permisoActual == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "No se pudo actualizar el Permiso");
        this.permisoService.update(permiso);
        Map<String,String>respuesta = new HashMap<>();
        respuesta.put("codigoRespuesta", "Ok");
        respuesta.put("msjRespuesta","Se Actualizo satisfactoriamente los datos del Permiso con codigo: "+ String.valueOf(idPermiso));
        return new ResponseEntity<Object>(respuesta, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrar(@PathVariable Long id) {
        Permiso matriculaActual = permisoService.findById(id);
        if (matriculaActual != null) {
            permisoService.delete(id);
            return new ResponseEntity<>("Se borro correctamente", HttpStatus.ACCEPTED);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro matricula con ese id");

    }


}
