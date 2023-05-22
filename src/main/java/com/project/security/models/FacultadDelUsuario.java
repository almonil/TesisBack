package com.project.security.models;

import com.project.security.security.models.Usuario;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "facultad_del_usuario")
public class FacultadDelUsuario {
    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "facultad_id")
    private Facultad facultad;

}
