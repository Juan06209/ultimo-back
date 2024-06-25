
package com.Avanfitt.servicio;

import com.Avanfitt.modelo.Factura;
import org.springframework.stereotype.Service;
import com.Avanfitt.repositorio.IFactura;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
author Juan
 */
@Service
public class FacturaServicio implements IFacturaServicio{
    
    @Autowired
     private IFactura facturaRepositorio;

    @Override
    public List<Factura> listarFacturas() {
    return facturaRepositorio.findAll();
    }

    @Override
    public Factura buscarFacturaPorId(Integer idFactura) {
    Factura factura = facturaRepositorio.findById(idFactura).orElse(null);
        return factura;
    }

    @Override
    public Factura guardarFactura(Factura factura) {
    return facturaRepositorio.save(factura);
    }

    @Override
    public void eliminarFactura(Factura factura) {
    facturaRepositorio.delete(factura);
    }
    
}
