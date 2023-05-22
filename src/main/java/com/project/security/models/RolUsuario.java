package com.project.security.models;

import com.project.security.security.models.Rol;
import com.project.security.security.models.Usuario;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "rol_usuario")
public class RolUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;

    // Getters y setters
}

