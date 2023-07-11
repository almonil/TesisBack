package com.project.security.services;

import com.project.security.models.ProcesoElectoral;
import com.project.security.repository.ProcesoElectoralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcesoElectoralService {
    private final ProcesoElectoralRepository procesoElectoralRepository;

    @Autowired
    public ProcesoElectoralService(ProcesoElectoralRepository procesoElectoralRepository) {
        this.procesoElectoralRepository = procesoElectoralRepository;
    }

    public List<ProcesoElectoral> obtenerProcesosElectorales() {
        return procesoElectoralRepository.findAll();
    }

    public Optional<ProcesoElectoral> obtenerProcesoElectoralPorId(Long id) {
        return procesoElectoralRepository.findById(id);
    }

    public ProcesoElectoral crearProcesoElectoral(ProcesoElectoral procesoElectoral) {
        return procesoElectoralRepository.save(procesoElectoral);
    }

    public Optional<ProcesoElectoral> actualizarProcesoElectoral(Long id, ProcesoElectoral procesoElectoral) {
        Optional<ProcesoElectoral> procesoElectoralExistente = procesoElectoralRepository.findById(id);
        if (procesoElectoralExistente.isPresent()) {
            procesoElectoral.setId(procesoElectoralExistente.get().getId());
            return Optional.of(procesoElectoralRepository.save(procesoElectoral));
        } else {
            return Optional.empty();
        }
    }

    public boolean eliminarProcesoElectoral(Long id) {
        Optional<ProcesoElectoral> procesoElectoralExistente = procesoElectoralRepository.findById(id);
        if (procesoElectoralExistente.isPresent()) {
            procesoElectoralRepository.delete(procesoElectoralExistente.get());
            return true;
        } else {
            return false;
        }
    }
}
