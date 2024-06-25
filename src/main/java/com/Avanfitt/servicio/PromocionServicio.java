
package com.Avanfitt.servicio;

import com.Avanfitt.modelo.Promocion;
import java.util.List;
import org.springframework.stereotype.Service;
import com.Avanfitt.repositorio.IPromocion;
import org.springframework.beans.factory.annotation.Autowired;

/**
author Juan
 */
@Service
public class PromocionServicio implements IPromocionServicio{
    
     @Autowired
     private IPromocion promocionRepositorio;

    @Override
    public List<Promocion> listarPromociones() {
    return promocionRepositorio.findAll();
    }

    @Override
    public Promocion buscarPromocionPorId(Integer idPromocion) {
    Promocion promocion = promocionRepositorio.findById(idPromocion).orElse(null);
        return promocion;
    }

    @Override
    public Promocion guardarPromocion(Promocion promocion) {
    return promocionRepositorio.save(promocion);
    }

    @Override
    public void eliminarPromocion(Promocion promocion) {
    promocionRepositorio.delete(promocion);

    }
    
}
