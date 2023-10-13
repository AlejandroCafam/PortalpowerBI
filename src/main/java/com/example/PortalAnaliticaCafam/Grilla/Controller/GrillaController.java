package com.example.PortalAnaliticaCafam.Grilla.Controller;

import com.example.PortalAnaliticaCafam.Grilla.Entity.Grilla;
import com.example.PortalAnaliticaCafam.Grilla.Service.GrillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/grilla")
public class GrillaController {
    @Autowired
    private  GrillaService grillaService;

    @PostMapping
    public ResponseEntity<Grilla> guardarGrilla(@RequestBody Grilla grilla) {
        Grilla nuevaGrilla = grillaService.guardarGrilla(grilla);
       return new ResponseEntity<>(nuevaGrilla,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Grilla>> obtenerGrilla() {
        List<Grilla> grillas = grillaService.obtenerGrilla();
        if(grillas!=null){
            return new ResponseEntity<>(grillas,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grilla> obtenerGrillaPorId(@PathVariable Long id) {
        Optional<Grilla> grilla = grillaService.obtenerGrillaPorId(id);
        return grilla.map(value-> new ResponseEntity<>(value,HttpStatus.OK))
                .orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grilla> actualizarGrilla(@PathVariable Long id, @RequestBody Grilla nuevaGrilla) {
        Grilla grillaActualizada = grillaService.update(id, nuevaGrilla);
        return grillaActualizada != null ? ResponseEntity.ok(grillaActualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarGrilla(@PathVariable Long id) {
        Optional<Grilla> grilla = grillaService.obtenerGrillaPorId(id);
        if(grilla.isPresent()){
            grillaService.deleteGrilla(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

