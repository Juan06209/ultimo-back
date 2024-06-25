
package com.Avanfitt.servicio;
import com.Avanfitt.modelo.CompraPrenda;
import java.util.List;
import org.springframework.stereotype.Service;
/**
@author Juan
 */
@Service
public interface ICompraPrendaServicio {
    
    public List<CompraPrenda> listarCompraPrendas();

    public CompraPrenda buscarCompraPrendaPorId(Integer idCompraPrenda);

    public CompraPrenda guardarCompraPrenda(CompraPrenda compraPrenda);

    public void eliminarCompraPrenda(CompraPrenda compraPrenda);
    
}
