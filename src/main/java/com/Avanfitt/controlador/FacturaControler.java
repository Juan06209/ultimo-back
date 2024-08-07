
package com.Avanfitt.controlador;

import com.Avanfitt.modelo.Factura;
import com.Avanfitt.servicio.IFacturaServicio;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
/**
@author Juan
 */
@RestController
@RequestMapping("Avanfitt")
@CrossOrigin("http://localhost:3000")
public class FacturaControler {
    
    private static final Logger logger
            = LoggerFactory.getLogger(FacturaControler.class);
    
    @Autowired
    private IFacturaServicio facturaServicio;
    
    @GetMapping("/factura")
    public List<Factura> obtenerFacturas() {
        var facturas = facturaServicio.listarFacturas();
        facturas.forEach((compra -> logger.info(facturas.toString())));
        return facturas;
    }
    
    @PostMapping("/facturas")
    public Factura agregarFactura(@RequestBody Factura factura) {
        logger.info("Factura a agregar: " + factura);
        return facturaServicio.guardarFactura(factura);
    }
    
    @GetMapping("/facturas/{id}")
    public ResponseEntity<Factura> consultarCompradorId(@PathVariable Integer id) {
        Factura factura = facturaServicio.buscarFacturaPorId(id);
        if (factura == null) {
        }
        return ResponseEntity.ok(factura);
    }
    
    @PutMapping("/facturas/{id}")
    public ResponseEntity<Factura> modificarFacturaId(@PathVariable Integer id, @RequestBody Factura facturaObj) {
        Factura factura = facturaServicio.buscarFacturaPorId(id);
        if (factura == null) {
            return ResponseEntity.notFound().build();
        }
        
        // Actualizar los campos de la factura existente con los valores del objeto recibido
        factura.setNPrendas(facturaObj.getNPrendas());
        factura.setTotalPagar(facturaObj.getTotalPagar());
        factura.setDescuento(facturaObj.getDescuento());
        factura.setCorreoElectronico(facturaObj.getCorreoElectronico());
        factura.setDireccion(facturaObj.getDireccion());
        factura.setFecha(facturaObj.getFecha());
        factura.setCompra(facturaObj.getCompra());
        
        // Guardar la factura actualizada
        Factura updatedFactura = facturaServicio.guardarFactura(factura);
        
        // Registrar la factura actualizada para fines de depuración
        logger.info("Factura actualizada: " + factura);
        
        // Retornar la respuesta
        return ResponseEntity.ok(updatedFactura);
    }
    
    @DeleteMapping("/facturas/{id}")
    public ResponseEntity<Map<String, Boolean>> EliminarFacturarId(@PathVariable Integer id) {
        Factura factura = facturaServicio.buscarFacturaPorId(id);
        if (factura== null) {
        }
        facturaServicio.eliminarFactura(factura);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
    
}
