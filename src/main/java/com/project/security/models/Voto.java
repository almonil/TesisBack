package com.project.security.models;


import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "voto")
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Usuario estudiante;

    @ManyToOne
    @JoinColumn(name = "proceso_electoral_id")
    private ProcesoElectoral procesoElectoral;

    @ManyToOne
    @JoinColumn(name = "candidato_id")
    private Candidato candidato;

    @Column(name = "activo")
    private Integer activo;

}
