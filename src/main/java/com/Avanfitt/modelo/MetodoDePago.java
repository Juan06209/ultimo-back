
package com.Avanfitt.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
@author Juan
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MetodoDePago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idMetodoDePago;
    String TiPoDeCuenta;
    String NCuenta;
    
}
