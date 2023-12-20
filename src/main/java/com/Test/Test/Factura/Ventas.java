package com.Test.Test.Factura;

import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class Ventas 
{
    private final FacturaRepository ventasRepo;

     public Factura FindFacturaByPersona(Integer id)
    {
        return ventasRepo.findById(id).orElse(null);
    }

    public void storeFactura(Factura factura)
    {
        ventasRepo.save(factura);
    }




}
