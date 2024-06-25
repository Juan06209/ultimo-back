
package com.Avanfitt.servicio;

import com.Avanfitt.modelo.Comprador;
import java.util.List;
import org.springframework.stereotype.Service;
/**
@author Juan
 */
@Service
public interface IComprardorServicios {
    
    public List<Comprador> listarCompradores();

    public Comprador buscarCompradorPorId(Integer idComprador);

    public Comprador guardarComprador(Comprador comprador);

    public void eliminarComprador(Comprador comprador);
    
}
