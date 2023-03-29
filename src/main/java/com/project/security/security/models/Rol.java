package com.project.security.security.models;

import com.project.security.security.enumerados.RolNombre;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Table (name = "rol")
@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Enumerated (EnumType.STRING)
    private RolNombre nombre;

    public Rol() {
    }

    public Rol(@NotNull RolNombre rolNombre) {
        this.nombre = rolNombre;
    }
}
