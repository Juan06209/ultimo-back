
package com.Avanfitt.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Avanfitt.modelo.Factura;
/**
@author Juan
 */

public interface IFactura extends JpaRepository<Factura, Integer>{
    
}
