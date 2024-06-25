
package com.Avanfitt.controlador;

import com.Avanfitt.modelo.MetodoDePago;
import com.Avanfitt.servicio.IMetodoDePagoServicio;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
public class MetodoDePagoControler {
    
    private static final Logger logger
            = LoggerFactory.getLogger(MetodoDePagoControler.class);
    
    @Autowired
    private IMetodoDePagoServicio metodoDePagoServicio;
    
    @GetMapping("/metodoDePago")
    public List<MetodoDePago> obtenerMetodosDePagos() {
        var metodosDePago = metodoDePagoServicio.listarMetodosDePago();
        metodosDePago.forEach((metodoDePago -> logger.info(metodosDePago.toString())));
        return metodosDePago;
    }
    
    @PostMapping("/metodoDePago")
    public MetodoDePago agregarMetodoDePago(@RequestBody MetodoDePago metodosDePago) {
        logger.info("Factura a agregar: " + metodosDePago);
        return metodoDePagoServicio.guardarMetodoDePago(metodosDePago);
    }
    
    @GetMapping("/metodoDePago/{id}")
    public ResponseEntity<MetodoDePago> consultarMetodoDePagoId(@PathVariable Integer id) {
        MetodoDePago metodosDePago = metodoDePagoServicio.buscarMetodoDePagoPorId(id);
        if (metodosDePago == null) {
        }
        return ResponseEntity.ok(metodosDePago);
    }
    
    @PutMapping("/metodoDePago/{id}")
    public ResponseEntity<MetodoDePago> ModificarMetodoDePagoId(@PathVariable Integer id, @RequestBody MetodoDePago metodosDePagoObj) {
        MetodoDePago metodosDePago = metodoDePagoServicio.buscarMetodoDePagoPorId(id);
        if (metodosDePago== null) {
        }
        metodoDePagoServicio.guardarMetodoDePago(metodosDePago);
        return ResponseEntity.ok(metodosDePago);
    }
    
    @DeleteMapping("/metodoDePago/{id}")
    public ResponseEntity<Map<String, Boolean>> EliminarMetodoDePagoId(@PathVariable Integer id) {
        MetodoDePago metodosDePago = metodoDePagoServicio.buscarMetodoDePagoPorId(id);
        if (metodosDePago== null) {
        }
        metodoDePagoServicio.eliminarMetodoDePago(metodosDePago);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
    
    
    
}
