package com.project.security.models;

import com.project.security.security.models.Usuario;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "candidato")
public class Candidato {
    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Usuario estudiante;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "activo")
    private Boolean activo;

    @ManyToOne
    @JoinColumn(name = "proceso_electoral_id")
    private ProcesoElectoral procesoElectoral;


}

