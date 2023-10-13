package com.example.PortalAnaliticaCafam.Menu.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "subdireccion")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Subdireccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sub", unique = true, nullable = false)
    private Long id;

    @Column(name = "descripcion",nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_padre")
    private Subdireccion padre; //relación recursiva

    @Column(name = "estado",nullable = false)
    private int estado; // 1 o 0 para decir si está o no activo

}
