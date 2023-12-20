package com.Test.Test.Persona;

import org.springframework.stereotype.Service;
import java.util.List;
import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class Directorio 
{

    private final PersonaRepository personRepo;

    public Persona FindpersonByid(Integer id)
    {
        return personRepo.findById(id).orElse(null);
    }

    public List<Persona> FindPersona()
    {
        return (List<Persona>) personRepo.findAll();
    }

    public void borrarPersona(Integer id) 
    {
        personRepo.deleteById(id);
    }

    public void storePersona(Persona persona)
    {
        persona.validarCamposObligatorios();
        personRepo.save(persona);
    }


}


