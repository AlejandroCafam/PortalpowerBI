package com.example.PortalAnaliticaCafam.Menu.Controller;
import com.example.PortalAnaliticaCafam.Menu.Entity.Subdireccion;
import com.example.PortalAnaliticaCafam.Menu.Service.SubdireccionService;
import com.example.PortalAnaliticaCafam.Tablero.Entity.Tablero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subdirecciones")
public class SubdireccionController {
    @Autowired
    private SubdireccionService subdireccionService;

    @GetMapping()
    public ResponseEntity<List<Subdireccion>> obtenerSubdirecciones() {
        List<Subdireccion> subdireccionesRaiz = subdireccionService.encontrarSubdirecciones();
        if (!subdireccionesRaiz.isEmpty()) {
            return new ResponseEntity<>(subdireccionesRaiz, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/negocios")
    public ResponseEntity<List<Subdireccion>> obtenerNegocios() {
        List<Subdireccion> subdireccionesConPadres = subdireccionService.encontrarNegocios();
        if (!subdireccionesConPadres.isEmpty()) {
            return new ResponseEntity<>(subdireccionesConPadres, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/negocios/tercer")
    public ResponseEntity<List<Subdireccion>> obtenerNegocios2() {
        List<Subdireccion> subdireccionesConPadres = subdireccionService.encontrarNegocios2();
        if (!subdireccionesConPadres.isEmpty()) {
            return new ResponseEntity<>(subdireccionesConPadres, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Subdireccion> crearSubdireccion(@RequestBody Subdireccion subdireccion) {
        Subdireccion nuevaSubdireccion = subdireccionService.guardarSubdireccion(subdireccion);
        return new ResponseEntity<>(nuevaSubdireccion, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subdireccion> obtenerSubdireccionPorId(@PathVariable Long id) {
        Optional<Subdireccion> subdireccion = subdireccionService.obtenerSubdireccionPorId(id);
        return subdireccion.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subdireccion> actualizarSubdireccion(@PathVariable Long id, @RequestBody Subdireccion subdireccion) {
        Optional<Subdireccion> subdireccionExistente = subdireccionService.obtenerSubdireccionPorId(id);
        if (subdireccionExistente.isPresent()) {
            subdireccion.setId(id);
            Subdireccion actualizadaSubdireccion = subdireccionService.guardarSubdireccion(subdireccion);
            return new ResponseEntity<>(actualizadaSubdireccion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSubdireccion(@PathVariable Long id) {
        Optional<Subdireccion> subdireccion = subdireccionService.obtenerSubdireccionPorId(id);
        if (subdireccion.isPresent()) {
            subdireccionService.eliminarSubdireccion(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/hijos/{idPadre}")
    public ResponseEntity<List<Subdireccion>> getHijosByPadreId(@PathVariable Long idPadre) {
        List<Subdireccion> hijos = subdireccionService.findHijosByPadreId(idPadre);
        if (!hijos.isEmpty()){
            return new ResponseEntity<>(hijos,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


}
