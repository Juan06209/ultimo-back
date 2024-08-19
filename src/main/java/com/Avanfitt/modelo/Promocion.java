package com.Avanfitt.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Juan
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Promocion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPromocion;
    
    @Column(name = "tipo_de_descuento")
    private Integer tipoDeDescuento;
}
