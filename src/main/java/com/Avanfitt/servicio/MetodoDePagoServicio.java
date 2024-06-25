
package com.Avanfitt.servicio;

import com.Avanfitt.modelo.MetodoDePago;
import org.springframework.stereotype.Service;
import com.Avanfitt.repositorio.IMetodoDePago;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
@author Juan
 */
@Service
public class MetodoDePagoServicio implements IMetodoDePagoServicio{
    
     @Autowired
     private IMetodoDePago metodoDePagoRepositorio;

    @Override
    public List<MetodoDePago> listarMetodosDePago() {
    return metodoDePagoRepositorio.findAll();
    }

    @Override
    public MetodoDePago buscarMetodoDePagoPorId(Integer idMetodoDePago) {
    MetodoDePago MetodoDePago = metodoDePagoRepositorio.findById(idMetodoDePago).orElse(null);
        return MetodoDePago;
    }

    @Override
    public MetodoDePago guardarMetodoDePago(MetodoDePago metodoDePago) {
    return metodoDePagoRepositorio.save(metodoDePago);
    }

    @Override
    public void eliminarMetodoDePago(MetodoDePago metodoDePago) {
     metodoDePagoRepositorio.delete(metodoDePago);
    }
    
}
