package com.project.security.models;

import com.project.security.security.models.Usuario;

import javax.persistence.*;

@Entity
public class UsuarioProgramaAcademico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "programa_academico")
    private String programaAcademico;

    // Constructor, getters y setters

}