package com.example.PortalAnaliticaCafam.Grilla.Service;

import com.example.PortalAnaliticaCafam.Grilla.Entity.Grilla;
import com.example.PortalAnaliticaCafam.Grilla.Repository.GrillaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrillaService {
    @Autowired
    private GrillaRepository grillaRepository;

    public Grilla guardarGrilla(Grilla grilla){
        return grillaRepository.save(grilla);
    }
    public List<Grilla> obtenerGrilla(){
        return grillaRepository.findAll();
    }

    public Optional<Grilla> obtenerGrillaPorId(Long id){
        return grillaRepository.findById(id);
    }

    public Grilla update(Long id, Grilla nuevaGrilla){
        Grilla grilla= grillaRepository.findById(id).orElse(null);
        if(grilla!= null){
            grilla.setNombre(nuevaGrilla.getNombre());
            return grillaRepository.save(grilla);
        }
        return null;
    }
    public void deleteGrilla(Long id){
        grillaRepository.deleteById(id);
    }


}
