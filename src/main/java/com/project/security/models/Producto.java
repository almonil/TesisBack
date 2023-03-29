package com.project.security.models;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@Table (name = "producto")
@Entity
public class Producto {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotBlank
    private String nombre;

    @NotNull
    @NotBlank
    @Column (unique = true)
    private String codigo;

    @NotNull
    @NotBlank
    private String descripcion;

    @NotNull
    @Positive
    private double precio;

    private Integer habilitado = 1;

    public Producto() {
    }

    public Producto(Integer id, String nombre, String codigo, String descripcion, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }
}
