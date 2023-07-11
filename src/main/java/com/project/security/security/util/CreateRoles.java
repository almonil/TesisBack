package com.project.security.security.util;

import com.project.security.security.enumerados.RolNombre;
import com.project.security.security.models.Rol;
import com.project.security.security.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {
        Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
        Rol rolUser = new Rol(RolNombre.ROLE_USER);
        Rol rolAuditor = new Rol(RolNombre.ROLE_AUDITOR);
        Rol rolJefeArea = new Rol(RolNombre.ROLE_JEFE_AREA);

        rolService.save(rolAdmin);
        rolService.save(rolUser);
        rolService.save(rolAuditor);
        rolService.save(rolJefeArea);
    }
}


