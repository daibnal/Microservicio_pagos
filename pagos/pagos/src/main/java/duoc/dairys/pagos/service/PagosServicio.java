package duoc.dairys.pagos.service;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import duoc.dairys.pagos.model.Pagos;
import duoc.dairys.pagos.repository.PagosRepositorio;


public class PagosServicio {
    @Autowired
    private PagosRepositorio pagosRepositorio;


    public boolean procesarPago(Pagos pagos){
        if(pagos.getMonto() <= 0){
            return false;
        }
        pagos.setEstado("PROCESANDO");

        pagosRepositorio.save(pagos);

        return true;
    }


    public boolean confirmarPago(Long idPagos){
        Pagos pagos = pagosRepositorio.findById(idPagos).orElse(null);
            //validar si existe el pago
            if(pagos == null){
                return false;
            }

            //cambiar estado
            pagos.setEstado("CONFIRMADO");

            //guardar cambios
            pagosRepositorio.save(pagos);
            return true;
        
    }

    public boolean rechazarPago(long idPagos){
        Pagos pagos = pagosRepositorio.findById(idPagos).orElse(null);

            //validar si existe el pago
            if(pagos == null){
                return false;
            }
            //cambiar estado
            pagos.setEstado("RECHAZADO");

            //guardar cambios
            pagosRepositorio.save(pagos);
            return true;
    }

    

    public boolean cambiarEstado(Long idPagos, String nuevoEstado){
        Pagos pagos = pagosRepositorio.findById(idPagos).orElse(null);
            //validar existencia del pago
            if(pagos == null){
                return false;
            }

            //cambiar estado
            pagos.setEstado(nuevoEstado);

            //guardar cambios
            pagosRepositorio.save(pagos);
            return true;
    }
}
