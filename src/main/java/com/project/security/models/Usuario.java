package com.project.security.models;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;


}
