package com.project.security.repository;

import com.project.security.models.ProcesoElectoral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcesoElectoralRepository extends JpaRepository<ProcesoElectoral, Long> {
    // Agrega métodos personalizados de consulta si es necesario
}
