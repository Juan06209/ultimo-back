
package com.Avanfitt.repositorio;
import com.Avanfitt.modelo.MetodoDePago;
import org.springframework.data.jpa.repository.JpaRepository;
/**
@author Juan
 */

public interface IMetodoDePago extends JpaRepository<MetodoDePago, Integer>{
    
}
