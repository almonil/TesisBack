package com.project.security.services;

import com.project.security.models.Voto;
import com.project.security.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotoService {

    @Autowired
    private VotoRepository votoRepository;

    public void guardarVoto(Voto voto) {
        String nombreVotante = voto.getNombreVotante();

        // Verificar si el usuario ya ha votado
        boolean usuarioYaVoto = votoRepository.existsByNombreVotante(nombreVotante);

        if (usuarioYaVoto) {
            throw new RuntimeException("El usuario ya ha votado anteriormente.");
        }

        // Procede a guardar el voto en la base de datos
        votoRepository.save(voto);
        // Realiza las acciones necesarias después de guardar el voto
    }

    public List<Voto> obtenerVotos() {
        return votoRepository.findAll();
    }

    public void guardarVotoEstudiante(Voto voto) {
        votoRepository.save(voto);
    }
    public boolean obtenerVotos(String nombreVotante) {
        return votoRepository.existsByNombreVotante(nombreVotante);
    }
}
