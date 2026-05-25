package duoc.dairys.pagos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import duoc.dairys.pagos.DTO.PagoDTO;
import duoc.dairys.pagos.model.Pago;
import duoc.dairys.pagos.service.PagosServicio;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/pago")
public class PagosControlador {
    @Autowired
    private PagosServicio pagosServicio;


    //procesar pago
    @PostMapping("/procesar")
    public ResponseEntity<?> procesarPago(@Valid @RequestBody PagoDTO dto){
        Boolean procesado = pagosServicio.procesarPago(dto);

        if(procesado){
            return ResponseEntity.ok("Pago procesado correctamente");

        }
        return ResponseEntity.badRequest().body("Error al procesar pago");
    }

    //confirmar pago
    @PutMapping("/confirmar/{idPago}")
    public ResponseEntity<?> confirmarPago(@Valid @PathVariable Long idPago){
        boolean confirmado = pagosServicio.confirmarPago(idPago);

        if(!confirmado){
            return ResponseEntity.status(404).body("Pago no encontrado");
        }
        return ResponseEntity.ok("Pago confirmado correctamente");
    }

    @PutMapping("/rechazar/{idPago}")
    public ResponseEntity<?> rechazarPago(@PathVariable Long idPago){
        boolean rechazado = pagosServicio.rechazarPago(idPago);

        if(!rechazado){
            return ResponseEntity.status(404).body("Pago no encontrado");
        }
        return ResponseEntity.ok("Pago rechazado");
    }

    @PutMapping("/estado/{idPago}")
    public ResponseEntity<?> cambiarEstado(@PathVariable Long idPago, @RequestParam String estado){
        boolean actualizado = pagosServicio.cambiarEstado(idPago, estado);

        if(!actualizado){
            return ResponseEntity.status(404).body("Pago no encontrado");
        }
        return ResponseEntity.ok("Estado actualizado correctamente");
    }
    
}
