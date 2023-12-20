package com.Test.Test.Factura;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Ventas")
@RequiredArgsConstructor

public class FacturaRestService
{
    private final  Ventas ventasService;

    @GetMapping("/Factura/{id}")
    public Factura FindFacturaByPersona(@PathVariable Integer id) 
    {
        return ventasService.FindFacturaByPersona(id);
    }

    @PostMapping("/factura")
    public void storeFactura(@RequestBody Factura factura)
    {
        ventasService.storeFactura(factura);
    }

}
