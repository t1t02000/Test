package com.Test.Test.Factura;

import org.springframework.stereotype.Service;

import com.Test.Test.Persona.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor

public class Ventas 
{

    private final FacturaRepository ventasRepo;

    @Autowired
    private PersonaRepository personaRepository;

     public Factura FindFacturaByPersona(Integer id)
    {
        log.info("Buscando factura de persona con ID: {}", id);
        List<Factura> facturas = findFacturasByPersona(id);
        return facturas.isEmpty() ? null : facturas.get(0);
    }

    public List<Factura> findFacturasByPersona(Integer personaId) 
    {
        log.info("Buscando todas las facturas de la persona con ID: {}", personaId);
        return ventasRepo.findByPersonaId(personaId);
    }

    public void storeFactura(Factura factura)
    {
        log.info("Creando nueva factura: {}", factura);
        validarPersonaExistente(factura);
        factura.validarCampos();
        ventasRepo.save(factura);
    }

    private void validarPersonaExistente(Factura factura) {
        if (factura.getPersona() == null || factura.getPersona().getId() == null ||
            !personaRepository.existsById(factura.getPersona().getId())) {
                log.error("El id de la persona en la factura no existe en la base de datos");
                throw new IllegalArgumentException("El id de la persona en la factura no existe en la base de datos");
        }
    }



    
}
