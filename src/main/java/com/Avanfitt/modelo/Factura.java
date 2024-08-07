
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;


/**
@author Juan
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Factura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    Integer idFactura;
    
    @Temporal(TemporalType.DATE)
    Date Fecha;
    
    Integer NPrendas;
    Integer TotalPagar;
    Integer Descuento;
    String CorreoElectronico;
    String Direccion;
    
    @ManyToOne
    @JoinColumn(name = "id_compra")
    Compra compra; 
    
    
}
