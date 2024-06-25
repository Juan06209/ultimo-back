
package com.Avanfitt.servicio;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Avanfitt.modelo.Compra;
import com.Avanfitt.repositorio.ICompra;

/**
@author Juan
 */
@Service
public class CompraServicio implements ICompraServicio{

    @Autowired
     private ICompra compraRepositorio;
    
    @Override
    public List<Compra> listarCompras() {
    return compraRepositorio.findAll();
    }

    @Override
    public Compra buscarCompraPorId(Integer idCompra) {
    Compra compra = compraRepositorio.findById(idCompra).orElse(null);
        return compra;
    }

    @Override
    public Compra guardarCompra(Compra compra) {
    return compraRepositorio.save(compra);
    }

    @Override
    public void eliminarCompra(Compra compra) {
    compraRepositorio.delete(compra);
    }
    
    
    
}
