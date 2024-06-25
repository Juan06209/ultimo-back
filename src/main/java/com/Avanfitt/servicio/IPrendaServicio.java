
package com.Avanfitt.servicio;

import org.springframework.stereotype.Service;
import com.Avanfitt.modelo.Prenda;
import java.util.List;

/**
@author Juan
 */
@Service
public interface IPrendaServicio {
    
    public List<Prenda> listarPrendas();

    public Prenda buscarPrendaPorId(Integer idPrenda);

    public Prenda guardarPrenda(Prenda prenda);

    public void eliminarPrenda(Prenda prenda);
    
}
