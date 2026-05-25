package duoc.dairys.pagos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import duoc.dairys.pagos.model.Pago;
import duoc.dairys.pagos.repository.PagosRepositorio;

@Service
public class PagosServicio {
    @Autowired
    private PagosRepositorio pagosRepositorio;


    public boolean procesarPago(Pago pago){
        if(pago.getMonto() <= 0){
            return false;
        }
        pago.setEstado("PROCESANDO");

        pagosRepositorio.save(pago);

        return true;
    }


    public boolean confirmarPago(Long idPago){
        Pago pago = pagosRepositorio.findById(idPago).orElse(null);
            //validar si existe el pago
            if(pago == null){
                return false;
            }

            //cambiar estado
            pago.setEstado("CONFIRMADO");

            //guardar cambios
            pagosRepositorio.save(pago);
            return true;
        
    }

    public boolean rechazarPago(long idPago){
        Pago pago = pagosRepositorio.findById(idPago).orElse(null);

            //validar si existe el pago
            if(pago == null){
                return false;
            }
            //cambiar estado
            pago.setEstado("RECHAZADO");

            //guardar cambios
            pagosRepositorio.save(pago);
            return true;
    }

    

    public boolean cambiarEstado(Long idPago, String nuevoEstado){
        Pago pago = pagosRepositorio.findById(idPago).orElse(null);
            //validar existencia del pago
            if(pago == null){
                return false;
            }

            //cambiar estado
            pago.setEstado(nuevoEstado);

            //guardar cambios
            pagosRepositorio.save(pago);
            return true;
    }
}
