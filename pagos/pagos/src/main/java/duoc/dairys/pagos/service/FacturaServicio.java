package duoc.dairys.pagos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import duoc.dairys.pagos.model.Factura;
import duoc.dairys.pagos.repository.FacturaRepositorio;

@Service
public class FacturaServicio {

    @Autowired
    private FacturaRepositorio facturaRepositorio;

    //obtener facturas
    public List<Factura> obtenerFacturas(){
        return facturaRepositorio.findAll();
    }

    //guardar factura
    public Factura guardarFactura(Factura factura){
        return facturaRepositorio.save(factura);
    }

    //generar factura
    public boolean generarFactura(Long idFactura){
        Factura factura = facturaRepositorio.findById(idFactura).orElse(null);

        if(factura == null){
            return false;
        }

        factura.setEstado("FACTURA GENERADA");

        facturaRepositorio.save(factura);
        return true;
    }

    //anular factura
    public boolean anularFactura(Long idFactura){
        Factura factura = facturaRepositorio.findById(idFactura).orElse(null);

        if(factura == null){
            return false;
        }

        factura.setEstado("FACTURA ANULADA");

        facturaRepositorio.save(factura);
        return true;
    }


    
}
