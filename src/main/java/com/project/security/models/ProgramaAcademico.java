package com.project.security.models;

import com.project.security.security.models.Usuario;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "programa_academico")
public class ProgramaAcademico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "facultad_id")
    private Facultad facultad;

    @ManyToOne
    @JoinColumn(name = "jefe_area_id")
    private Usuario jefeArea;

    // Constructor, getters y setters

    // Otros métodos y lógica adicional
}
