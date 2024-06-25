
package com.Avanfitt.servicio;

import com.Avanfitt.modelo.CompraPrenda;
import com.Avanfitt.repositorio.ICompraPrenda;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
@author Juan
 */
@Service
public class CompraPrendaServicio implements ICompraPrendaServicio{
    
    @Autowired
     private ICompraPrenda compraPrendaRepositorio;

    @Override
    public List<CompraPrenda> listarCompraPrendas() {
    return compraPrendaRepositorio.findAll();
    }

    @Override
    public CompraPrenda buscarCompraPrendaPorId(Integer idCompraPrenda) {
    CompraPrenda compraPrenda = compraPrendaRepositorio.findById(idCompraPrenda).orElse(null);
        return compraPrenda;
    }

    @Override
    public CompraPrenda guardarCompraPrenda(CompraPrenda compraPrenda) {
    return compraPrendaRepositorio.save(compraPrenda);
    }

    @Override
    public void eliminarCompraPrenda(CompraPrenda compraPrenda) {
    compraPrendaRepositorio.delete(compraPrenda);
    }
    
}
