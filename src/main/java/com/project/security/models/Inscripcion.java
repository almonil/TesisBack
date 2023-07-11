package com.project.security.models;

import com.project.security.security.models.Usuario;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Inscripcion")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_estudiante")
    private String nombreEstudiante;

    @Column(name = "semestre_cursado")
    private int semestreCursado;

    @Column(name = "programa_academico")
    private String programaAcademico;

    @Column(name = "candidato_principal")
    private boolean candidatoPrincipal;

    @Column(name = "fecha_inscripcion")
    private Date fechaInscripcion;

    @Column(name = "estado_inscripcion")
    private String estadoInscripcion;

    @Column(name = "notas")
    private String notas;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Usuario estudiante;

    // Constructores, getters y setters, y otros métodos

    // Constructor vacío
    public Inscripcion() {
    }

    // Constructor con los campos obligatorios
    public Inscripcion(String nombreEstudiante, int semestreCursado, String programaAcademico, boolean candidatoPrincipal) {
        this.nombreEstudiante = nombreEstudiante;
        this.semestreCursado = semestreCursado;
        this.programaAcademico = programaAcademico;
        this.candidatoPrincipal = candidatoPrincipal;
    }

    // Getters y setters para todas las propiedades

    public Usuario getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Usuario estudiante) {
        this.estudiante = estudiante;
    }

    public void setId(Long id) {
        this.id = id;
    }


    // ...
}
