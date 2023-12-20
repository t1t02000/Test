package com.Test.Test.Factura;

import org.springframework.stereotype.Service;

import com.Test.Test.Persona.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.RequiredArgsConstructor;

import java.util.List;
@Service
@RequiredArgsConstructor

public class Ventas 
{

    private final FacturaRepository ventasRepo;

    @Autowired
    private PersonaRepository personaRepository;

     public Factura FindFacturaByPersona(Integer id)
    {
        List<Factura> facturas = findFacturasByPersona(id);
        return facturas.isEmpty() ? null : facturas.get(0);
    }

    public List<Factura> findFacturasByPersona(Integer personaId) 
    {
        return ventasRepo.findByPersonaId(personaId);
    }

    public void storeFactura(Factura factura)
    {
        validarPersonaExistente(factura);
        factura.validarCampos();
        ventasRepo.save(factura);
    }

    private void validarPersonaExistente(Factura factura) {
        if (factura.getPersona() == null || factura.getPersona().getId() == null ||
            !personaRepository.existsById(factura.getPersona().getId())) {
            throw new IllegalArgumentException("El id de la persona en la factura no existe en la base de datos");
        }
    }
    



}
