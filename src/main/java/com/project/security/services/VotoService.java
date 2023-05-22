package com.project.security.services;

import com.project.security.models.Voto;
import com.project.security.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotoService {

    @Autowired
    private VotoRepository votoRepository;


    public void guardarVotoEstudiante(Voto voto) {
        votoRepository.save(voto);
    }
}
