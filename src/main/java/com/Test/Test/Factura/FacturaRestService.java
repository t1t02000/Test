package com.Test.Test.Factura;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Ventas")
@RequiredArgsConstructor

public class FacturaRestService
{
    private final  Ventas ventasService;

    @GetMapping("/factura/{id}")
    public Factura FindFacturaByPersona(@PathVariable Integer id) 
    {
        return ventasService.FindFacturaByPersona(id);
    }

    @GetMapping("/facturasPorPersona/{personaId}")
    public List<Factura> findFacturasByPersona(@PathVariable Integer personaId) {
        return ventasService.findFacturasByPersona(personaId);
    }

    @PostMapping("/factura")
    public ResponseEntity<String> storeFactura(@RequestBody Factura factura)
    {
        try {
                ventasService.storeFactura(factura);
                return ResponseEntity.ok("Factura guardada correctamente");
        } catch (IllegalArgumentException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

}
