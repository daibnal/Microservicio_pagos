package duoc.dairys.pagos.controller;

import org.springframework.web.bind.annotation.RestController;

import duoc.dairys.pagos.model.Factura;
import duoc.dairys.pagos.service.FacturaServicio;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/facturas")
public class FacturaControlador {
    
    @Autowired
    private FacturaServicio facturaServicio;
    

    //obtener facturas
    @GetMapping
    public ResponseEntity<?> obtenerFacturas(){
        return ResponseEntity.ok(facturaServicio.obtenerFacturas());
    }

    //guardar factura
    @PostMapping("/guardar")
    public ResponseEntity<?> guardarFactura(@Valid @RequestBody Factura factura){
        return ResponseEntity.status(201).body(facturaServicio.guardarFactura(factura));
    }

    //generar factura
    @PutMapping("/generar/{id}")
    public ResponseEntity<?> generarFactura(@PathVariable Long id){
        boolean generada = facturaServicio.generarFactura(id);

        if(!generada){
            return ResponseEntity.status(404).body("Factura no encontrada");
        }
        return ResponseEntity.ok("Factura generada");

    }

    //anular factura
    @PutMapping("/anular/{id}")
    public ResponseEntity<?> anularFactura(@PathVariable Long id){
        boolean anulada = facturaServicio.anularFactura(id);

        if(!anulada){
            return ResponseEntity.status(404).body("Factura no encontrada");
        }
        return ResponseEntity.ok("Factura anulada");
    }
    
    //obtener monto total
    @GetMapping("/montos")
    public ResponseEntity<?> obtenerMontoTotal(){
        List<Double> monto = facturaServicio.obtenerMontoTotal();
        
        if(monto.isEmpty()){
            return ResponseEntity.ok("No hay facturas registradas");
        }
        return ResponseEntity.ok(monto);

    }
}
