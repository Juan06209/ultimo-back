
package com.Avanfitt.servicio;

import com.Avanfitt.modelo.Compra;
import java.util.List;
import org.springframework.stereotype.Service;

/**
@author Juan
 */

@Service
public interface ICompraServicio {
    
    public List<Compra> listarCompras();

    public Compra buscarCompraPorId(Integer idCompra);

    public Compra guardarCompra(Compra compra);

    public void eliminarCompra(Compra compra);
    
}
