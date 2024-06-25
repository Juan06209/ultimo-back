
package com.Avanfitt.servicio;

import com.Avanfitt.modelo.Prenda;
import java.util.List;
import org.springframework.stereotype.Service;
import com.Avanfitt.repositorio.IPrenda;
import org.springframework.beans.factory.annotation.Autowired;

/**
@author Juan
 */
@Service
public class PrendaServicio implements IPrendaServicio{
    
    @Autowired
     private IPrenda prendaRepositorio;

    @Override
    public List<Prenda> listarPrendas() {
    return prendaRepositorio.findAll();
    }

    @Override
    public Prenda buscarPrendaPorId(Integer idPrenda) {
    Prenda prenda = prendaRepositorio.findById(idPrenda).orElse(null);
        return prenda;
    }

    @Override
    public Prenda guardarPrenda(Prenda prenda) {
    return prendaRepositorio.save(prenda);
    }

    @Override
    public void eliminarPrenda(Prenda prenda) {
    prendaRepositorio.delete(prenda);
    }
    
}
