package com.project.security.security.rest;

import com.project.security.security.dto.JwtDto;
import com.project.security.security.dto.LoginUsuario;
import com.project.security.security.dto.Mensaje;
import com.project.security.security.dto.NuevoUsuario;
import com.project.security.security.enumerados.RolNombre;
import com.project.security.security.jwt.JwtProvider;
import com.project.security.security.jwt.JwtTokenFilter;
import com.project.security.security.models.Rol;
import com.project.security.security.models.Usuario;
import com.project.security.security.service.RolService;
import com.project.security.security.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping ("/auth")
@CrossOrigin ("http://localhost:4200")
public class AuthRest {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping ("/nuevo-usuario")
    @CrossOrigin ("*")
    public ResponseEntity<?> nuevo (@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(new Mensaje("campos mal puestos o imail invalido"), HttpStatus.BAD_REQUEST);
        }
        if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario())) {
            return new ResponseEntity<>(new Mensaje("ese nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail())) {
            return new ResponseEntity<>(new Mensaje("ese email ya existe"), HttpStatus.BAD_REQUEST);
        }
        Usuario usuario =
                new Usuario(nuevoUsuario.getNombre(),nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(),
                        passwordEncoder.encode(nuevoUsuario.getPassword()));
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        if(nuevoUsuario.getRoles().contains("admin")) {
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        }
        if(nuevoUsuario.getRoles().contains("auditor")) {
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_AUDITOR).get());
        }
        if(nuevoUsuario.getRoles().contains("Director_AREA")) {
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_JEFE_AREA).get());
        }
        if(nuevoUsuario.getRoles().contains("GESTION_HUMANA")) {
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_GESTION_HUMANA).get());
        }


        usuario.setRoles(roles);
        usuarioService.save(usuario);
        return new ResponseEntity<>(new Mensaje("usuario guardado"), HttpStatus.CREATED);

    }

    @PostMapping ("/login")
    @CrossOrigin ("http://localhost:4200/login")
    public ResponseEntity<?> login (@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
        JwtDto jwtDto = new JwtDto("undefined","undefined",null);
        try {
            if(bindingResult.hasErrors()) {
                return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
            }
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(),
                            loginUsuario.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateToken(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        } catch (Exception exception) {
            return new ResponseEntity<>("no autorizado", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(jwtDto, HttpStatus.OK);
    }
}


