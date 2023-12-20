package com.Test.Test.Factura;

import java.time.LocalDate;

import com.Test.Test.Persona.Persona;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
@Entity

public class Factura
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descripcion;
    private Double monto;

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    private LocalDate fecha;

    public Factura() {
        this.fecha = LocalDate.now(); // Establecer la fecha actual por defecto al crear la factura
    }

    public Factura(String descripcion, Double monto, Persona persona, LocalDate fecha) {
        this.descripcion = descripcion;
        this.monto = monto;
        this.persona = persona;
        this.fecha = fecha;
        validarCampos();
    }


        public Factura validarCampos() {
            if (esNullOrEmpty(descripcion) ||
                monto == null ||
                monto <= 0 ||
                fecha == null) {
                throw new IllegalArgumentException("Todos los campos de Factura son obligatorios");
            }
            return this;
        }
    
        private boolean esNullOrEmpty(String str) {
            return str == null || str.trim().isEmpty();
        }
   
}

