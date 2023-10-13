package com.example.PortalAnaliticaCafam.Tablero.Controller;

import com.example.PortalAnaliticaCafam.Menu.Entity.Subdireccion;
import com.example.PortalAnaliticaCafam.Menu.Service.SubdireccionService;
import com.example.PortalAnaliticaCafam.Tablero.Entity.Tablero;
import com.example.PortalAnaliticaCafam.Tablero.Service.TableroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tablero")
public class TableroController {
    @Autowired
    private  TableroService tableroService;
    @Autowired
    private SubdireccionService subdireccionService;


    @GetMapping()
    public ResponseEntity<List<Tablero>> getAllTableros() {
        List<Tablero> tableros = tableroService.getAllTableros();
        if(!tableros.isEmpty()){
            return new ResponseEntity<>(tableros, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tablero> getTableroById(@PathVariable int id) {
        Optional<Tablero> tableros = tableroService.getTableroById(id);
        return tableros.map(value-> new ResponseEntity<>(value,HttpStatus.OK))
                .orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<Tablero> createTablero(@RequestBody Tablero tablero) {
        Tablero tableros = tableroService.createTablero(tablero);
        return new ResponseEntity<>(tableros, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Tablero updateTablero(@PathVariable int id, @RequestBody Tablero tablero) {
        return tableroService.updateTablero(id, tablero);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTablero(@PathVariable int id) {
        Optional<Tablero> tableros = tableroService.getTableroById(id);
        if(tableros.isPresent()) {
            tableroService.deleteTablero(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    /*@GetMapping("/by-subdireccion/{subdireccionId}")
    public ResponseEntity<Optional<Tablero>> getTablerosBySubdireccion(@PathVariable Long subdireccionId) {
        Optional<Subdireccion> subdireccion = Optional.ofNullable(subdireccionService.obtenerSubdireccionPorId(subdireccionId).orElse(null));
        if (subdireccion != null) {
            return new ResponseEntity<>(subdireccion,HttpStatus.OK);
        } else {
            // Manejar el caso en el que la Subdireccion no existe
            throw new SubdireccionNotFoundException("Subdireccion con ID " + subdireccionId + " no encontrada");
        }
    }*/
    @GetMapping("/by-subdireccion/{subdireccionId}")
    public ResponseEntity<List<Tablero>> getTablerosBySubdireccion(@PathVariable Long subdireccionId) {
        Subdireccion subdireccion = subdireccionService.obtenerSubdireccionPorId(subdireccionId).orElse(null);
        if (subdireccion != null) {
            List<Tablero> tableros = tableroService.getTablerosBySubdireccion(subdireccion);

            return new ResponseEntity<>(tableros, HttpStatus.OK);
        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
