package com.project.security.models;


import com.project.security.security.models.Usuario;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estudiante_id", referencedColumnName = "id")
    private Usuario estudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proceso_electoral_id", referencedColumnName = "id")
    private ProcesoElectoral procesoElectoral;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidato_id", referencedColumnName = "id")
    private Candidato candidato;

    @Column(name = "activo")
    private Integer activo;

}
