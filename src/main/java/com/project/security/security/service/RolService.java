package com.project.security.security.service;

import com.project.security.security.enumerados.RolNombre;
import com.project.security.security.models.Rol;
import com.project.security.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre (RolNombre rolNombre) {
        return rolRepository.findByNombre(rolNombre);
    }

    public void save (Rol rol) {
        rolRepository.save(rol);
    }
}
