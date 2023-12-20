package com.Test.Test.Persona;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder

public class Persona 
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_seq")
    private Integer id;
    @Basic
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String identificacion;
    
    // Constructor que requiere todos los atributos excepto apellidoMaterno
    public Persona(Integer id, String Nombre, String apellidoPaterno, String identificacion) 
    {
        this.id = id;
        this.nombre = Nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.identificacion = identificacion;
    }


    public Persona validarCamposObligatorios() {
        if (esNullOrEmpty(nombre) ||
            esNullOrEmpty(apellidoPaterno) ||
            esNullOrEmpty(identificacion)) {
            throw new IllegalArgumentException("Todos los campos de Persona son obligatorios");
        }
        return this;
    }

    private boolean esNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
   
}
