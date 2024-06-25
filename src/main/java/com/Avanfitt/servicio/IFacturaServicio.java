
package com.Avanfitt.servicio;
import com.Avanfitt.modelo.Factura;
import java.util.List;
import org.springframework.stereotype.Service;

/**
@author Juan
 */
@Service
public interface IFacturaServicio {
    
    public List<Factura> listarFacturas();

    public Factura buscarFacturaPorId(Integer idFactura);

    public Factura guardarFactura(Factura factura);

    public void eliminarFactura(Factura factura);
    
}
