package duoc.dairys.pagos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import duoc.dairys.pagos.model.MetodoPago;
import duoc.dairys.pagos.repository.MtdoPagoRepositorio;

@Service
public class MtdoPagoServicio {
    @Autowired
    private MtdoPagoRepositorio metodoPagoRepositorio;

    //obtener todos los metodos de pagos
    public List<MetodoPago> obtenerMetodos(){
        return metodoPagoRepositorio.findAll();
    }

    //guardar metodo de pago
    public MetodoPago guardarMetodo(MetodoPago metodoPago){
        return metodoPagoRepositorio.save(metodoPago);
    }

    //activar metodo
    public boolean activarMetodo(Long idMetodo){
        MetodoPago metodo = metodoPagoRepositorio.findById(idMetodo).orElse(null);

        if(metodo == null){
            return false;
        }

        metodo.setActivo(true);
        metodoPagoRepositorio.save(metodo);

        return true;
    }

    //desactivar metodo
    public boolean desactivarMetodo(Long idMetodo){
        MetodoPago metodo = metodoPagoRepositorio.findById(idMetodo).orElse(null);

        if(metodo == null){
            return false;
        }

        metodo.setActivo(false);
        metodoPagoRepositorio.save(metodo);

        return true;
    }





    
}
