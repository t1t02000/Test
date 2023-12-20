package com.Test.Test.Persona;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Directorio")
@RequiredArgsConstructor
public class DirectorioRestService 
{
    
    private final Directorio directorioService;


    @GetMapping("/persona/{id}")
    public Persona FindpersonByid(@PathVariable Integer id) 
    {
        return directorioService.FindpersonByid(id);
    }

    @GetMapping("/persona")
    public List<Persona> FindPersona() 
    {
        return directorioService.FindPersona();
    }

    @DeleteMapping("/persona/{id}")
    public void borrarPersona(@PathVariable Integer id)
    {
        directorioService.borrarPersona(id);
    }

    @PostMapping("/persona")
    public ResponseEntity<String> storePersona(@RequestBody Persona persona)
    {
        try {
                directorioService.storePersona(persona);
                return ResponseEntity.ok("Persona guardada correctamente");
        } catch (IllegalArgumentException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        
    }



}
