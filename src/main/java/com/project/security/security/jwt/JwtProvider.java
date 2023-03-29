package com.project.security.security.jwt;

import com.project.security.security.models.UsuarioPrincipal;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value ("${jwt.secret}")
    private String secret;

    @Value ("${jwt.expiration}")
    private int expiration;

    public String generateToken (Authentication authentication) {
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();

        return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String getNombreUsuarioFromToken (String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken (String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException exception) {
            logger.error("token mal formado");
        } catch (UnsupportedJwtException exception) {
            logger.error("token no soportado");
        } catch (ExpiredJwtException exception) {
            logger.error("token expirado");
        } catch (IllegalArgumentException exception) {
            logger.error("token vacío");
        } catch (SignatureException exception) {
            logger.error("falló la firma del token");
        }
        return false;
    }
}
