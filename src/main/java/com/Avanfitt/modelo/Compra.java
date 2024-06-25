
package com.Avanfitt.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
/**
@author Juan
 */

public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idCompra;
    Integer Cantidad;
    Integer Precio;
    
    @ManyToOne
    @JoinColumn(name = "id_comprador")
    Comprador comprador; 
    
    @ManyToOne
    @JoinColumn(name = "id_metodo_de_pago")
    MetodoDePago metododepago;
    
    @ManyToOne
    @JoinColumn(name = "id_promocion")
    Promocion promocion; 
    
}
