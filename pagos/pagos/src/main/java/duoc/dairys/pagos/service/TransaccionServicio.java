package duoc.dairys.pagos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import duoc.dairys.pagos.model.Transaccion;
import duoc.dairys.pagos.repository.TransaccionRepositorio;

@Service
public class TransaccionServicio {
    
    @Autowired
    private TransaccionRepositorio transaccionRepositorio;

    //obtener transacciones
    public List<Transaccion> obtenerTransacciones(){
        return transaccionRepositorio.findAll();
    }

    //guardar Transaccion
    public Transaccion guardarTransaccion(Transaccion transaccion){
        return transaccionRepositorio.save(transaccion);
    }

    //confirmar transaccion
    public boolean confirmarTransaccion(Long idTransaccion){
        Transaccion transaccion = transaccionRepositorio.findById(idTransaccion).orElse(null);

        //validar la existencia de la transaccio 
        if(transaccion == null){
            return false;
        }

        //cambiar estado
        transaccion.setEstado("CONFIRMADA");

        //guardar cambios
        transaccionRepositorio.save(transaccion);
        return true;
    }

    //anular transaccion
    public boolean anularTransaccion(Long idTransaccion){
        Transaccion transaccion = transaccionRepositorio.findById(idTransaccion).orElse(null);

        //validar la existencia de la transaccion
        if(transaccion == null){
            return false;
        }

        //cambiar estado
        transaccion.setEstado("ANULADA");

        //guardar cambios
        transaccionRepositorio.save(transaccion);
        return true;
    }

}
