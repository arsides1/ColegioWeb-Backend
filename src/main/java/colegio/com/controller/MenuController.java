package colegio.com.controller;

import colegio.com.model.Menu;
import colegio.com.service.MenuService;
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
@RequestMapping("/Menu")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar()  {
        List<Menu> menus = this.menuService.listarMenu();


        return ResponseEntity.ok(menus);
		/*Collection<Menu> menu = menuService.findAll();
		return new ResponseEntity<>(menu, HttpStatus.OK);*/
    }


    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable(name = "id") Long menuId) {
        Menu menu = menuService.findById(menuId);
        if (menu == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro Menu con ese id");
        }
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }


    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody Menu menu) {
        Map<String,String>respuesta = new HashMap<>();

        try {
            menuService.insert(menu);
            respuesta.put("codigoRespuesta", "Ok");
            respuesta.put("msjRespuesta","Se creo Satisfactoriamente la nueva Menu con codigo: " + menu.getIdMenu());
            respuesta.put("fechaCreacion", new Date(0).toString());
        }
        catch(Exception ex) {

            respuesta.put("CodigoRespuesta", "FAIL");
            respuesta.put("msjRespuesta","El Menu ya se encuentra registrado");
        }
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }



   /* @PutMapping("/actualizar")
   //@RequestMapping(value = "/actualizar", method = { RequestMethod.GET, RequestMethod.PUT })
    public ResponseEntity<?> actualizar(@RequestBody Menu menu) {



        menuService.actualizarMenu(menu);

        Map<String,String>respuesta = new HashMap<>();


        try {
            menuService.actualizarMenu(menu);
            respuesta.put("codigoRespuesta", "Ok");
            respuesta.put("msjRespuesta","Se Actualizo el Menu con codigo: " + menu.getIdMenu());
            respuesta.put("fechaCreacion", new Date(0).toString());
        }
        catch(Exception ex) {

            respuesta.put("CodigoRespuesta", "FAIL");
            respuesta.put("msjRespuesta","Ya se encuentra Menudo");
        }
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }


*/


 @PutMapping("/editar/{id}")
/*@RequestMapping(value = "/editar/{id}",
        produces = "application/json",
        method={ RequestMethod.GET, RequestMethod.PUT })*/
    //@RequestMapping(value = "/editar/{id}", method = {RequestMethod.PUT })
    public ResponseEntity<?> editar(@PathVariable(name = "id") Long idMenu,
                                    @RequestBody Menu menu) {
        Menu menuActual = menuService.findById(idMenu);
//        if (menuActual != null) {
//            menuActual.setDescripcion(menu.getDescripcion());
//            menuActual.setFechaInicio(menu.getFechaInicio());
//            menuActual.setFechaFin(menu.getFechaFin());
//            menuActual.setEstado(menu.getEstado());
//            menuActual.setFechaRegistro(menu.getFechaRegistro());
//            menuService.update(menuActual);
//            return new ResponseEntity<>(menuActual, HttpStatus.ACCEPTED);
//        }
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro Menu con ese id");

        //Menu menuActual = menuService.findById(idMenu);
        if (menuActual == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "No se pudo actualizar el Menu");
        this.menuService.update(menu);
        Map<String,String>respuesta = new HashMap<>();
        respuesta.put("codigoRespuesta", "Ok");
        respuesta.put("msjRespuesta","Se Actualizo satisfactoriamente los datos del Menu con codigo: "+ String.valueOf(idMenu));
        return new ResponseEntity<Object>(respuesta, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrar(@PathVariable Long id) {
        Menu menuActual = menuService.findById(id);
        if (menuActual != null) {
            menuService.delete(id);
            return new ResponseEntity<>("Se borro correctamente", HttpStatus.ACCEPTED);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro matricula con ese id");

    }


}
