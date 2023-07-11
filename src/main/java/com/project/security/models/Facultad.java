package com.project.security.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "facultad")
public class Facultad {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "numero_telefonico")
    private String numeroTelefonico;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    @Column(name = "ubicacion")
    private String ubicacion;

    @JoinColumn(name = "nombre_decano")
    private String decano;

    @Column(name = "activo")
    private Integer activo;


}

