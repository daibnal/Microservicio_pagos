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
    public MetodoPago activarMetodo(Long idMetodo){
        MetodoPago metodo = metodoPagoRepositorio.findById(idMetodo)
        .orElseThrow(() -> new RuntimeException("No existe el método"));

    metodo.setActivo(true);

    return metodoPagoRepositorio.save(metodo);
}

    //desactivar metodo
    public boolean desactivarMetodo(Long idMetodo){
    return metodoPagoRepositorio.findById(idMetodo)
        .map(metodo -> {
            metodo.setActivo(false);
            metodoPagoRepositorio.save(metodo);
            return true;
        })
        .orElse(false);
    }

}
