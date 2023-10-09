package com.example.PortalAnaliticaCafam.Tablero.Repository;


import com.example.PortalAnaliticaCafam.Menu.Entity.Subdireccion;
import com.example.PortalAnaliticaCafam.Tablero.Entity.Tablero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TableroRepository extends JpaRepository<Tablero, Integer> {
    @Query("SELECT t FROM Tablero t WHERE t.subdireccion = :subdireccion")
    List<Tablero> findBySubdireccion(@Param("subdireccion") Subdireccion subdireccion);
}
