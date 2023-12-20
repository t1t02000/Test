package com.Test.Test.Persona;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Persona 
{

    @Id
    @GeneratedValue
    private Integer id;
    @Basic
    private String Nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String identificacion;

    // Constructor que requiere todos los atributos excepto apellidoMaterno
    public Persona(Integer id, String Nombre, String apellidoPaterno, String identificacion) 
    {
        this.id = id;
        this.Nombre = Nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.identificacion = identificacion;
    }

   
}
