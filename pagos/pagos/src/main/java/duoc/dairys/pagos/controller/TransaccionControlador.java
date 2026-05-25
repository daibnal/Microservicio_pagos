package duoc.dairys.pagos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import duoc.dairys.pagos.model.Transaccion;
import duoc.dairys.pagos.service.TransaccionServicio;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/transacciones")
public class TransaccionControlador {
    
    @Autowired
    private TransaccionServicio transaccionServicio;
    

    //obtener transacciones
    @GetMapping
    public ResponseEntity<?> obtenerTransacciones(){
        return ResponseEntity.ok(transaccionServicio.obtenerTransacciones());
    }
    
    //guardar transacciones
    @PostMapping("/guardar")
    public ResponseEntity<?> guardarTransaccion(@Valid @RequestBody Transaccion transaccion){
        return ResponseEntity.status(201).body(transaccionServicio.guardarTransaccion(transaccion));
    }

    //confirmar transaccion
    @PutMapping("/confirmar/{id}")
    public ResponseEntity<?> confirmarTransaccion(@PathVariable Long id){
        boolean confirmada = transaccionServicio.confirmarTransaccion(id);

        if(!confirmada){
            return ResponseEntity.status(404).body("Transaccion no encontrada");
        }
        return ResponseEntity.ok("Transaccion confirmada");
    }

    //anular transaccion
    @PutMapping("/anular/{id}")
    public ResponseEntity<?> anularTransaccion(@PathVariable Long id){
        boolean anulada = transaccionServicio.anularTransaccion(id);

        if(!anulada){
            return ResponseEntity.status(404).body("Transaccion no encontrada");
        }
        return ResponseEntity.ok("Transaccion anulada");
    }

    
}
