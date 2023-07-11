package com.project.security.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Voto")
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "activo")
    private int activo;

    @Column(name = "nombre_votante", unique = true) // Se agrega la restricción unique
    private String nombreVotante;

    @ManyToOne
    @JoinColumn(name = "inscripcion_id")
    private Inscripcion inscripcion;

    // Constructores, getters y setters, y otros métodos

    // Constructor vacío
    public Voto() {
    }

    // Constructor con los campos obligatorios
    public Voto(int activo, String nombreVotante) {
        this.activo = activo;
        this.nombreVotante = nombreVotante;
    }

    // Getters y setters para todas las propiedades

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    // ...
}
