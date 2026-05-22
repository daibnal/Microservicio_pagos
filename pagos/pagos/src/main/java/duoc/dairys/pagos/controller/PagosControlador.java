package duoc.dairys.pagos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import duoc.dairys.pagos.model.Pagos;
import duoc.dairys.pagos.service.PagosServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("api/v1/eco_market_spa")
public class PagosControlador {
    @Autowired
    private PagosServicio pagosServicio;

    @PostMapping("/Procesar")
    public ResponseEntity<?> procesarPago(@RequestBody Pagos pagos){
        Boolean procesado = pagosServicio.procesarPago(pagos);

        if(procesado){
            return ResponseEntity.ok("Pago procesado correctamente");

        }
        return ResponseEntity.badRequest().body("Error al procesar pago");
    }

    @PutMapping("/confirmar/{id}")
    public ResponseEntity<?> confirmarPago(@PathVariable Long idPagos){
        boolean confirmado = pagosServicio.confirmarPago(idPagos);

        if(!confirmado){
            return ResponseEntity.status(404).body("Pago no encontrado");
        }
        return ResponseEntity.ok("Pago confirmado correctamente");
    }

    @PutMapping("/rechazar/{id}")
    public ResponseEntity<?> rechazarPago(@PathVariable Long idPagos){
        boolean rechazado = pagosServicio.rechazarPago(idPagos);

        if(!rechazado){
            return ResponseEntity.status(404).body("Pago no encontrado");
        }
        return ResponseEntity.ok("Pago rechazado");
    }

    @PutMapping("/estado/{id}")
    public ResponseEntity<?> cambiarEstado(@PathVariable Long idPagos, @RequestParam String estado){
        boolean actualizado = pagosServicio.cambiarEstado(idPagos, estado);

        if(!actualizado){
            return ResponseEntity.status(404).body("Pago no encontrado");
        }
        return ResponseEntity.ok("Estado actualizado correctamente");
    }


    
}
