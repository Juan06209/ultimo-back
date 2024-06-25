
package com.Avanfitt.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class CompraPrenda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idCompraPrenda;
    Integer Cantidad;
    
    @ManyToOne
    @JoinColumn(name = "id_prenda")
    Prenda prenda; 
    
    @ManyToOne
    @JoinColumn(name = "id_compra")
    Compra compra; 
    
}
