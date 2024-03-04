package com.example.examenadeval2ejercicio2.servicio;


import org.springframework.stereotype.Service;

@Service
public class SecurityService {
    public Boolean validarToken(String token) {
        return (token.equals("t0k3n"));
    }
}
