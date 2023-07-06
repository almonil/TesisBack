package com.project.security.rest;

import com.project.security.models.ProcesoElectoral;
import com.project.security.repository.ProcesoElectoralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/procesos-electorales")
@CrossOrigin(origins = "http://localhost:4200")

public class ProcesoElectoralController {
    private final ProcesoElectoralRepository procesoElectoralRepository;

    @Autowired
    public ProcesoElectoralController(ProcesoElectoralRepository procesoElectoralRepository) {
        this.procesoElectoralRepository = procesoElectoralRepository;
    }

    @GetMapping
    public ResponseEntity<List<ProcesoElectoral>> obtenerProcesosElectorales() {
        List<ProcesoElectoral> procesosElectorales = procesoElectoralRepository.findAll();
        return ResponseEntity.ok(procesosElectorales);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcesoElectoral> obtenerProcesoElectoralPorId(@PathVariable("id") Long id) {
        ProcesoElectoral procesoElectoral = procesoElectoralRepository.findById(id)
                .orElse(null);
        if (procesoElectoral != null) {
            return ResponseEntity.ok(procesoElectoral);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ProcesoElectoral> crearProcesoElectoral(@RequestBody ProcesoElectoral procesoElectoral) {
        ProcesoElectoral nuevoProcesoElectoral = procesoElectoralRepository.save(procesoElectoral);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProcesoElectoral);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProcesoElectoral> actualizarProcesoElectoral(
            @PathVariable("id") Long id, @RequestBody ProcesoElectoral procesoElectoral) {
        ProcesoElectoral procesoElectoralExistente = procesoElectoralRepository.findById(id)
                .orElse(null);
        if (procesoElectoralExistente != null) {
            procesoElectoral.setId(procesoElectoralExistente.getId());
            ProcesoElectoral procesoElectoralActualizado = procesoElectoralRepository.save(procesoElectoral);
            return ResponseEntity.ok(procesoElectoralActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProcesoElectoral(@PathVariable("id") Long id) {
        ProcesoElectoral procesoElectoralExistente = procesoElectoralRepository.findById(id)
                .orElse(null);
        if (procesoElectoralExistente != null) {
            procesoElectoralRepository.delete(procesoElectoralExistente);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
