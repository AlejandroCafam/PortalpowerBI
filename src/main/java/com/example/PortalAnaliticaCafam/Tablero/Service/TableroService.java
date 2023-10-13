package com.example.PortalAnaliticaCafam.Tablero.Service;

import com.example.PortalAnaliticaCafam.Menu.Entity.Subdireccion;
import com.example.PortalAnaliticaCafam.Tablero.Entity.Tablero;
import com.example.PortalAnaliticaCafam.Tablero.Repository.TableroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TableroService {
    @Autowired
    private  TableroRepository tableroRepository;

    public List<Tablero> getAllTableros() {
        return tableroRepository.findAll();
    }

    public Optional<Tablero> getTableroById(int id) {
        return tableroRepository.findById(id);
    }

    public Tablero createTablero(Tablero tablero) {
        return tableroRepository.save(tablero);
    }

    public Tablero updateTablero(int id, Tablero tableroDetails) {
        Tablero existingTablero = tableroRepository.findById(id).orElse(null);
        if (existingTablero != null) {
            existingTablero.setTipo(tableroDetails.getTipo());
            existingTablero.setReporte(tableroDetails.getReporte());
            existingTablero.setDescripcion(tableroDetails.getDescripcion());
            existingTablero.setVinculo(tableroDetails.getVinculo());
            existingTablero.setId_sub(tableroDetails.getId_sub());
            return tableroRepository.save(existingTablero);
        }
        return null;
    }

    public void deleteTablero(int id) {
        tableroRepository.deleteById(id);
    }
    public List<Tablero> getTablerosBySubdireccion(Subdireccion subdireccion) {
        return tableroRepository.findBySubdireccion(subdireccion);
    }

}
