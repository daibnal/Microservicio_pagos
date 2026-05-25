package duoc.dairys.pagos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import duoc.dairys.pagos.model.MetodoPago;
import duoc.dairys.pagos.service.MtdoPagoServicio;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/metodos")
public class MtdoPagoControlador {
    @Autowired
    private MtdoPagoServicio metodoPagoServicio;
    
    //obtener todos los metodos de pagos
    @GetMapping
    public ResponseEntity<?> obtenerMetodos(){
        return ResponseEntity.ok(metodoPagoServicio.obtenerMetodos());
    }
    

    //guardar metodos de pagos
    @PostMapping("/guardar")
    public ResponseEntity<?> guardarMetodo(@Valid @RequestBody MetodoPago metodoPago){
        return ResponseEntity.status(201).body(metodoPagoServicio.guardarMetodo(metodoPago));
    }

    //activar método de pago
    @PutMapping("/activar/{id}")
    public MetodoPago activarMetodo(@PathVariable Long id){
        return metodoPagoServicio.activarMetodo(id);
    }

    //desactivar método de pago
    @PutMapping("/desactivar/{id}")
    public ResponseEntity<?> desactivarMetodo(@PathVariable Long id){
        boolean desactivado = metodoPagoServicio.desactivarMetodo(id);

        if(!desactivado){
            return ResponseEntity.status(404).body("Metodo de pago no encontrado");
        }
        return ResponseEntity.ok("Metodo desactivado correctamente");
    }


    
}
