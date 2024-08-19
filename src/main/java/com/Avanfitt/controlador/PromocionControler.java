
package com.Avanfitt.controlador;

import com.Avanfitt.modelo.Promocion;
import com.Avanfitt.servicio.IPromocionServicio;
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

public class PromocionControler {
    
    private static final Logger logger
            = LoggerFactory.getLogger(CompraControler.class);
    
    @Autowired
    private IPromocionServicio promocionServicio;
    
    @GetMapping("/promociones")
public List<Promocion> obtenerPromociones() {
    var promociones = promocionServicio.listarPromociones();
    promociones.forEach(promocion -> logger.info("Promocion: " + promocion.toString()));
    return promociones;
}

    
    @PostMapping("/promociones")
    public Promocion agregarPromocion(@RequestBody Promocion promocion) {
        logger.info("Promocion a agregar: " + promocion);
        return promocionServicio.guardarPromocion(promocion);
    }
    
    @GetMapping("/promociones/{id}")
    public ResponseEntity<Promocion> consultarPromocionId(@PathVariable Integer id) {
        Promocion promocion = promocionServicio.buscarPromocionPorId(id);
        if (promocion == null) {
        }
        return ResponseEntity.ok(promocion);
    }
    
    @PutMapping("/promociones/{id}")
public ResponseEntity<Promocion> ModificarPromocionId(@PathVariable Integer id, @RequestBody Promocion promocionObj) {
    // Buscar la promoción por id
    Promocion promocion = promocionServicio.buscarPromocionPorId(id);
    
    // Verificar si la promoción existe
    if (promocion == null) {
        return ResponseEntity.notFound().build(); // Retorna un 404 Not Found si la promoción no existe
    }

    // Actualizar el atributo TipoDeDescuento
    promocion.setTipoDeDescuento(promocionObj.getTipoDeDescuento());

    // Guardar los cambios en la promoción
    promocionServicio.guardarPromocion(promocion);
    
    // Retornar la promoción actualizada con un estado 200 OK
    return ResponseEntity.ok(promocion);
}
    
    @DeleteMapping("/promociones/{id}")
    public ResponseEntity<Map<String, Boolean>> EliminarPrendaId(@PathVariable Integer id) {
        Promocion promocion = promocionServicio.buscarPromocionPorId(id);
        if (promocion== null) {
        }
        promocionServicio.eliminarPromocion(promocion);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
    
}
