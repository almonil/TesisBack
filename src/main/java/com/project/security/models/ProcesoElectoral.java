package com.project.security.models;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "proceso_electoral")
public class ProcesoElectoral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "anio")
    private LocalDateTime anio;

    @Column(name = "vuelta")
    private String vuelta;

    @Column(name = "activo")
    private boolean activo;

    @Column(name = "activar_votaciones_comite_curricular")
    private boolean activarVotacionesComiteCurricular;

    @Column(name = "activar_votaciones_consejo_directivo")
    private boolean activarVotacionesConsejoDirectivo;

    @Column(name = "nombre_resolucion_comite_curricular")
    private String nombreResolucionComiteCurricular;

    @Column(name = "nombre_resolucion_consejo_directivo")
    private String nombreResolucionConsejoDirectivo;

    // Agrega más campos para las entidades y fechas necesarias

    @Column(name = "inscripcion_inicio")
    private LocalDateTime inscripcionInicio;

    @Column(name = "inscripcion_fin")
    private LocalDateTime inscripcionFin;

    @Column(name = "publicacion_elegibles_inicio")
    private LocalDateTime publicacionElegiblesInicio;

    @Column(name = "publicacion_elegibles_fin")
    private LocalDateTime publicacionElegiblesFin;

    @Column(name = "jornada_electoral_inicio")
    private LocalDateTime jornadaElectoralInicio;

    @Column(name = "jornada_electoral_fin")
    private LocalDateTime jornadaElectoralFin;

    // Constructor, getters y setters
}
