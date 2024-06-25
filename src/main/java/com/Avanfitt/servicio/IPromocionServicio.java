
package com.Avanfitt.servicio;

import com.Avanfitt.modelo.Promocion;
import java.util.List;
import org.springframework.stereotype.Service;

/**
@author Juan
 */
@Service
public interface IPromocionServicio {
    
     public List<Promocion> listarPromociones();

    public Promocion buscarPromocionPorId(Integer idPromocion);

    public Promocion guardarPromocion(Promocion promocion);

    public void eliminarPromocion(Promocion promocion);
    
}
