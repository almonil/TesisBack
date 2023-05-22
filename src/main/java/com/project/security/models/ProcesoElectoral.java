package com.project.security.models;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "proceso_electoral")
public class ProcesoElectoral {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "tipo_de_voto")
    private String tipoDeVoto;

}
