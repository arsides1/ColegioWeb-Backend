package colegio.com.controller;

import colegio.com.model.SubMenu;
import colegio.com.service.SubMenuService;
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
@RequestMapping("/SubMenu")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SubMenuController {

    private final SubMenuService subMenuService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar()  {
        List<SubMenu> subMenus = this.subMenuService.listarSubMenu();


        return ResponseEntity.ok(subMenus);
		/*Collection<SubMenu> subMenu = subMenuService.findAll();
		return new ResponseEntity<>(subMenu, HttpStatus.OK);*/
    }


    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable(name = "id") Long subMenuId) {
        SubMenu subMenu = subMenuService.findById(subMenuId);
        if (subMenu == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro SubMenu con ese id");
        }
        return new ResponseEntity<>(subMenu, HttpStatus.OK);
    }


    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody SubMenu subMenu) {
        Map<String,String>respuesta = new HashMap<>();

        try {
            subMenuService.insert(subMenu);
            respuesta.put("codigoRespuesta", "Ok");
            respuesta.put("msjRespuesta","Se creo Satisfactoriamente la nueva SubMenu con codigo: " + subMenu.getIdSubMenu());
            respuesta.put("fechaCreacion", new Date(0).toString());
        }
        catch(Exception ex) {

            respuesta.put("CodigoRespuesta", "FAIL");
            respuesta.put("msjRespuesta","El SubMenu ya se encuentra registrado");
        }
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }



   /* @PutMapping("/actualizar")
   //@RequestMapping(value = "/actualizar", method = { RequestMethod.GET, RequestMethod.PUT })
    public ResponseEntity<?> actualizar(@RequestBody SubMenu subMenu) {



        SubMenuService.actualizarSubMenu(subMenu);

        Map<String,String>respuesta = new HashMap<>();


        try {
            subMenuService.actualizarSubMenu(subMenu);
            respuesta.put("codigoRespuesta", "Ok");
            respuesta.put("msjRespuesta","Se Actualizo el SubMenu con codigo: " + subMenu.getIdSubMenu());
            respuesta.put("fechaCreacion", new Date(0).toString());
        }
        catch(Exception ex) {

            respuesta.put("CodigoRespuesta", "FAIL");
            respuesta.put("msjRespuesta","Ya se encuentra SubMenudo");
        }
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }


*/


 @PutMapping("/editar/{id}")
/*@RequestMapping(value = "/editar/{id}",
        produces = "application/json",
        method={ RequestMethod.GET, RequestMethod.PUT })*/
    //@RequestMapping(value = "/editar/{id}", method = {RequestMethod.PUT })
    public ResponseEntity<?> editar(@PathVariable(name = "id") Long idSubMenu,
                                    @RequestBody SubMenu subMenu) {
        SubMenu subMenuActual = subMenuService.findById(idSubMenu);
//        if (subMenuActual != null) {
//            subMenuActual.setDescripcion(subMenu.getDescripcion());
//            subMenuActual.setFechaInicio(subMenu.getFechaInicio());
//            subMenuActual.setFechaFin(subMenu.getFechaFin());
//            subMenuActual.setEstado(subMenu.getEstado());
//            subMenuActual.setFechaRegistro(subMenu.getFechaRegistro());
//            subMenuService.update(subMenuActual);
//            return new ResponseEntity<>(subMenuActual, HttpStatus.ACCEPTED);
//        }
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro SubMenu con ese id");

        //SubMenu subMenuActual = subMenuService.findById(idSubMenu);
        if (subMenuActual == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "No se pudo actualizar el SubMenu");
        this.subMenuService.update(subMenu);
        Map<String,String>respuesta = new HashMap<>();
        respuesta.put("codigoRespuesta", "Ok");
        respuesta.put("msjRespuesta","Se Actualizo satisfactoriamente los datos  SubMenu con codigo: "+ String.valueOf(idSubMenu));
        return new ResponseEntity<Object>(respuesta, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrar(@PathVariable Long id) {
        SubMenu matriculaActual = subMenuService.findById(id);
        if (matriculaActual != null) {
            subMenuService.delete(id);
            return new ResponseEntity<>("Se borro correctamente", HttpStatus.ACCEPTED);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro matricula con ese id");

    }


}
