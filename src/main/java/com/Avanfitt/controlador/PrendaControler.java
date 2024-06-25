
package com.Avanfitt.controlador;
import com.Avanfitt.modelo.Prenda;
import com.Avanfitt.servicio.IPrendaServicio;
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
public class PrendaControler {
    
    private static final Logger logger
            = LoggerFactory.getLogger(CompraControler.class);
    
    @Autowired
    private IPrendaServicio prendaServicio;
    
    @GetMapping("/Prendas")
    public List<Prenda> obtenerCompras() {
        var prendas = prendaServicio.listarPrendas();
        prendas.forEach((prenda -> logger.info(prenda.toString())));
        return prendas;
    }
    
    @PostMapping("/Prendas")
    public Prenda agregarPrenda(@RequestBody Prenda prenda) {
        logger.info("Prenda a agregar: " + prenda);
        return prendaServicio.guardarPrenda(prenda);
    }
    
    @GetMapping("/Prendas/{id}")
    public ResponseEntity<Prenda> consultarPrendaId(@PathVariable Integer id) {
        Prenda prenda = prendaServicio.buscarPrendaPorId(id);
        if (prenda == null) {
        }
        return ResponseEntity.ok(prenda);
    }
    
    @PutMapping("/Prendas/{id}")
    public ResponseEntity<Prenda> ModificarPrendaId(@PathVariable Integer id, @RequestBody Prenda prendaObj) {
        Prenda prenda = prendaServicio.buscarPrendaPorId(id);
        if (prenda== null) {
        }
        prendaServicio.guardarPrenda(prenda);
        return ResponseEntity.ok(prenda);
    }
    
    @DeleteMapping("/Prendas/{id}")
    public ResponseEntity<Map<String, Boolean>> EliminarPrendaId(@PathVariable Integer id) {
        Prenda prenda = prendaServicio.buscarPrendaPorId(id);
        if (prenda== null) {
        }
        prendaServicio.eliminarPrenda(prenda);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
    
}
