
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
public class Comprador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idComprador;
    Integer cc;
    String nombre;
    String contraseña;
    String direccion;
    String TEl;
    
    
}
