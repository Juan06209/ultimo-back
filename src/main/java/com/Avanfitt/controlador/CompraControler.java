
package com.Avanfitt.controlador;

import com.Avanfitt.modelo.Compra;
import com.Avanfitt.servicio.ICompraServicio;
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
public class CompraControler {
    
    private static final Logger logger
            = LoggerFactory.getLogger(CompraControler.class);
    
    @Autowired
    private ICompraServicio compraServicio;
    
    @GetMapping("/compras")
    public List<Compra> obtenerCompras() {
        var compras = compraServicio.listarCompras();
        compras.forEach((compra -> logger.info(compra.toString())));
        return compras;
    }
    
    @PostMapping("/compras")
    public Compra agregarCompra(@RequestBody Compra compra) {
        logger.info("Compra a agregar: " + compra);
        return compraServicio.guardarCompra(compra);
    }
    
    @GetMapping("/compras/{id}")
    public ResponseEntity<Compra> consultarCompraId(@PathVariable Integer id) {
        Compra compra = compraServicio.buscarCompraPorId(id);
        if (compra == null) {
        }
        return ResponseEntity.ok(compra);
    }
    
    @PutMapping("/compras/{id}")
    public ResponseEntity<Compra> ModificarCompraId(@PathVariable Integer id, @RequestBody Compra compraObj) {
        Compra compra = compraServicio.buscarCompraPorId(id);
        if (compra== null) {
        }
        compraServicio.guardarCompra(compra);
        return ResponseEntity.ok(compra);
    }
    
    @DeleteMapping("/compras/{id}")
    public ResponseEntity<Map<String, Boolean>> EliminarCompraId(@PathVariable Integer id) {
        Compra compra = compraServicio.buscarCompraPorId(id);
        if (compra== null) {
        }
        compraServicio.eliminarCompra(compra);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

    
    
}
