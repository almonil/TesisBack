package com.project.security.services;

import com.project.security.models.Inscripcion;
import com.project.security.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscripcionService {

    private final InscripcionRepository inscripcionRepository;

    @Autowired
    public InscripcionService(InscripcionRepository inscripcionRepository) {
        this.inscripcionRepository = inscripcionRepository;
    }

    public List<Inscripcion> obtenerTodasLasInscripciones() {
        return inscripcionRepository.findAll();
    }

    public Inscripcion obtenerInscripcionPorId(Long id) {
        return inscripcionRepository.findById(id).orElse(null);
    }

    public Inscripcion crearInscripcion(Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }

    public Inscripcion actualizarInscripcion(Long id, Inscripcion inscripcion) {
        Inscripcion inscripcionExistente = inscripcionRepository.findById(id).orElse(null);
        if (inscripcionExistente != null) {
            inscripcion.setId(id);
            return inscripcionRepository.save(inscripcion);
        } else {
            return null;
        }
    }

    public boolean eliminarInscripcion(Long id) {
        Inscripcion inscripcionExistente = inscripcionRepository.findById(id).orElse(null);
        if (inscripcionExistente != null) {
            inscripcionRepository.delete(inscripcionExistente);
            return true;
        } else {
            return false;
        }
    }
}
