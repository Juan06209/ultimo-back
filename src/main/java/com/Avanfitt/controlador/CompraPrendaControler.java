
package com.Avanfitt.controlador;


import com.Avanfitt.modelo.CompraPrenda;
import com.Avanfitt.servicio.ICompraPrendaServicio;
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
public class CompraPrendaControler {
    
     private static final Logger logger
            = LoggerFactory.getLogger(CompraPrendaControler.class);
     
     @Autowired
    private ICompraPrendaServicio compraPrendaServicio;
    
    @GetMapping("/compraPrendas")
    public List<CompraPrenda> obtenerCompraPrendas() {
        var compraPrendas = compraPrendaServicio.listarCompraPrendas();
        compraPrendas.forEach((compraPrenda -> logger.info(compraPrenda.toString())));
        return compraPrendas;
    }
    
    @PostMapping("/compraPrendas")
    public CompraPrenda agregarComprarenda(@RequestBody CompraPrenda compraPrenda) {
        logger.info("Compra a agregar: " + compraPrenda);
        return compraPrendaServicio.guardarCompraPrenda(compraPrenda);
    }
    
    @GetMapping("/compraspreda/{id}")
    public ResponseEntity<CompraPrenda> consultarCompraPrendaId(@PathVariable Integer id) {
        CompraPrenda compraPrenda = compraPrendaServicio.buscarCompraPrendaPorId(id);
        if (compraPrenda == null) {
        }
        return ResponseEntity.ok(compraPrenda);
    }
    
    @PutMapping("/comprasprenda/{id}")
    public ResponseEntity<CompraPrenda> modificarCompraPrendaId(@PathVariable Integer id, @RequestBody CompraPrenda compraPrendaObj) {
        CompraPrenda compraPrenda = compraPrendaServicio.buscarCompraPrendaPorId(id);
        if (compraPrenda == null) {
            return ResponseEntity.notFound().build();
        }
        
        // Actualizar los campos de la compraPrenda existente con los valores del objeto recibido
        compraPrenda.setCantidad(compraPrendaObj.getCantidad());
        compraPrenda.setPrenda(compraPrendaObj.getPrenda());
        compraPrenda.setCompra(compraPrendaObj.getCompra());
        
        // Guardar la compraPrenda actualizada
        CompraPrenda updatedCompraPrenda = compraPrendaServicio.guardarCompraPrenda(compraPrenda);
        
        // Registrar la compraPrenda actualizada para fines de depuración
        logger.info("CompraPrenda actualizada: " + compraPrenda);
        
        // Retornar la respuesta
        return ResponseEntity.ok(updatedCompraPrenda);
    }
    
    @DeleteMapping("/comprasprenda/{id}")
    public ResponseEntity<Map<String, Boolean>> EliminarCompraId(@PathVariable Integer id) {
        CompraPrenda compraPrenda = compraPrendaServicio.buscarCompraPrendaPorId(id);
        if (compraPrenda== null) {
        }
        compraPrendaServicio.eliminarCompraPrenda(compraPrenda);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
