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
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Factura
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

   
    private LocalDate Fecha;
    private Double monto;

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;


}
