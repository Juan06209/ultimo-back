
package com.Avanfitt.controlador;
import com.Avanfitt.modelo.Comprador;
import com.Avanfitt.servicio.IComprardorServicios;
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
public class CompradorControler {
    
    private static final Logger logger
            = LoggerFactory.getLogger(CompradorControler.class);
    
    @Autowired
    private IComprardorServicios compradorServicio;
    
    @GetMapping("/compradores")
    public List<Comprador> obtenerCompradores() {
        var compradores = compradorServicio.listarCompradores();
        compradores.forEach((comprador -> logger.info(comprador.toString())));
        return compradores;
    }
    
    @PostMapping("/Compradores")
    public Comprador agregarComprador(@RequestBody Comprador comprador) {
        logger.info("Comprador a agregar: " + comprador);
        return compradorServicio.guardarComprador(comprador);
    }
    
    @GetMapping("/Compradores/{id}")
    public ResponseEntity<Comprador> consultarCompradorId(@PathVariable Integer id) {
        Comprador comprador = compradorServicio.buscarCompradorPorId(id);
        if (comprador == null) {
        }
        return ResponseEntity.ok(comprador);
    }
    
    @PutMapping("/compradores/{id}")
    public ResponseEntity<Comprador> modificarCompradorId(@PathVariable Integer id, @RequestBody Comprador compradorObj) {
        Comprador comprador = compradorServicio.buscarCompradorPorId(id);
        if (comprador == null) {
            return ResponseEntity.notFound().build();
        }
        
        // Actualizar los campos del comprador existente con los valores del objeto recibido
        comprador.setCc(compradorObj.getCc());
        comprador.setNombre(compradorObj.getNombre());
        comprador.setContraseña(compradorObj.getContraseña());
        comprador.setDireccion(compradorObj.getDireccion());
        comprador.setTEl(compradorObj.getTEl());
        
        // Guardar el comprador actualizado
        Comprador updatedComprador = compradorServicio.guardarComprador(comprador);
        
        // Registrar el comprador actualizado para fines de depuración
        logger.info("Comprador actualizado: " + comprador);
        
        // Retornar la respuesta
        return ResponseEntity.ok(updatedComprador);
    }
   
   
    @DeleteMapping("/compradores/{id}")
    public ResponseEntity<Map<String, Boolean>> EliminarCompradorId(@PathVariable Integer id) {
        Comprador comprador = compradorServicio.buscarCompradorPorId(id);
        if (comprador== null) {
        }
        compradorServicio.eliminarComprador(comprador);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
    
}
