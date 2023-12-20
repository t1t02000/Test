package com.Test.Test.Persona;


import org.springframework.stereotype.Service;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
@RequiredArgsConstructor

public class Directorio 
{

    private final PersonaRepository personRepo;


    public Persona FindpersonByid(Integer id)
    {
        log.info("Buscando persona con ID: {}", id);
        return personRepo.findById(id).orElse(null);
    }

    public List<Persona> FindPersona()
    {
        log.info("Obteniendo todas las personas");
        return (List<Persona>) personRepo.findAll();
    }

    public void borrarPersona(Integer id) 
    {
        log.info("Borrando persona con ID: {}", id);
        personRepo.deleteById(id);
    }

    public void storePersona(Persona persona)
    {
        log.info("Se creo una nueva persona: {}", persona);
        persona.validarCamposObligatorios();
        personRepo.save(persona);
    }


}


