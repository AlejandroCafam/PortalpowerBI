package com.example.PortalAnaliticaCafam.Grilla.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "grilla")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Grilla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    private String nombre;
}
