package com.example.examenadeval2ejercicio2.servicio;


import org.springframework.stereotype.Service;

/**
 * Clase que proporciona servicios de seguridad, incluido la validación de tokens.
 */
@Service
public class SecurityService {
    /**
     * Comprueba que el token sea válido.
     *
     * @param token Token a validar.
     * @return true si el token es válido, false de lo contrario.
     */
    public Boolean validarToken(String token) {
        return (token.equals("t0k3n"));
    }
}
