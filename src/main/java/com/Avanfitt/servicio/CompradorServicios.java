
package com.Avanfitt.servicio;

import com.Avanfitt.modelo.Comprador;
import com.Avanfitt.repositorio.IComprador;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan
 */
@Service
public class CompradorServicios implements IComprardorServicios{
    
    @Autowired
     private IComprador compradorRepositorio;

    @Override
    public List<Comprador> listarCompradores() {
    return compradorRepositorio.findAll();
    }

    @Override
    public Comprador buscarCompradorPorId(Integer idComprador) {
    Comprador comprador = compradorRepositorio.findById(idComprador).orElse(null);
        return comprador;
    }

    @Override
    public Comprador guardarComprador(Comprador comprador) {
    return compradorRepositorio.save(comprador);
    }

    @Override
    public void eliminarComprador(Comprador comprador) {
    compradorRepositorio.delete(comprador);
    }
    
}
