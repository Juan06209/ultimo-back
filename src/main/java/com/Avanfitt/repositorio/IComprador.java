
package com.Avanfitt.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Avanfitt.modelo.Comprador;
/**
@author Juan
 */

public interface IComprador extends JpaRepository<Comprador, Integer>{
    
}
