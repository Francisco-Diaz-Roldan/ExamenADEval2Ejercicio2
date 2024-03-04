package com.example.examenadeval2ejercicio2.modelo;

import com.example.examenadeval2ejercicio2.enumerado.Estado;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private Integer ventas;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    private String direccion;

    private String email;

    private Integer edad;

    private String telefono;

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ventas=" + ventas +
                ", estado=" + estado +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                ", edad=" + edad +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}


