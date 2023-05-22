package com.project.security.rest;

import com.project.security.models.Voto;
import com.project.security.services.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/votos")
public class VotoController {

    @Autowired
    private VotoService votoService;

    @PostMapping
    public ResponseEntity<String> guardarVoto(@RequestBody Voto voto) {
        votoService.guardarVotoEstudiante(voto);
        return ResponseEntity.ok("Voto guardado correctamente");
    }
}
