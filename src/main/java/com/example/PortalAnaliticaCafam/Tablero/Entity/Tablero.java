package com.example.PortalAnaliticaCafam.Tablero.Entity;

import com.example.PortalAnaliticaCafam.Menu.Entity.Subdireccion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tablero")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tablero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tab", unique = true, nullable = false)
    private int id;
    private String tipo;
    private String reporte;
    private String descripcion;
    private String vinculo;
    @ManyToOne
    @JoinColumn(name = "id_sub", nullable = false)
    private Subdireccion subdireccion;

}

