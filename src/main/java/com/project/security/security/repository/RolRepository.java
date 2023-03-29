package com.project.security.security.repository;

import com.project.security.security.enumerados.RolNombre;
import com.project.security.security.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByNombre (RolNombre rolNombre);
}
