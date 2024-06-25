
package com.Avanfitt.servicio;


import org.springframework.stereotype.Service;
import com.Avanfitt.modelo.MetodoDePago;
import java.util.List;

/*@author Juan
 */

@Service
public interface IMetodoDePagoServicio {
    public List<MetodoDePago> listarMetodosDePago();

    public MetodoDePago buscarMetodoDePagoPorId(Integer idMetodoDePago);

    public MetodoDePago guardarMetodoDePago(MetodoDePago metodoDePago);

    public void eliminarMetodoDePago(MetodoDePago metodoDePago);
    
}
