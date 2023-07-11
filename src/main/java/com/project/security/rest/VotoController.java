package com.project.security.rest;

import com.project.security.models.Voto;
import com.project.security.services.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/votos")
@CrossOrigin(origins = "http://localhost:4200")
public class VotoController {

    @Autowired
    private VotoService votoService;

    @PostMapping
    public ResponseEntity<String> guardarVoto(@RequestBody Voto voto) {
        votoService.guardarVotoEstudiante(voto);
        return ResponseEntity.ok("Voto guardado correctamente");
    }

    @GetMapping
    public ResponseEntity<List<Voto>> obtenerVotos() {
        List<Voto> votos = votoService.obtenerVotos();
        return ResponseEntity.ok(votos);
    }
}
