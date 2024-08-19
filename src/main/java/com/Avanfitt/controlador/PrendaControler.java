
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
import org.springframework.http.HttpStatus;
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
public ResponseEntity<Prenda> agregarPrenda(@RequestBody Prenda prenda) {
    try {
        logger.info("Prenda a agregar: " + prenda);
        Prenda nuevaPrenda = prendaServicio.guardarPrenda(prenda);
        return ResponseEntity.ok(nuevaPrenda);
    } catch (Exception e) {
        logger.error("Error al agregar prenda: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
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
    // Buscar la prenda por id
    Prenda prenda = prendaServicio.buscarPrendaPorId(id);
    
    // Verificar si la prenda existe
    if (prenda == null) {
        return ResponseEntity.notFound().build(); // Retorna un 404 Not Found si la prenda no existe
    }

    // Actualizar los atributos de la prenda
    prenda.setDescripcion(prendaObj.getDescripcion());
    prenda.setPrecio(prendaObj.getPrecio());
    prenda.setDisponibilidad(prendaObj.getDisponibilidad());

    // Guardar los cambios en la prenda
    prendaServicio.guardarPrenda(prenda);
    
    // Retornar la prenda actualizada con un estado 200 OK
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
