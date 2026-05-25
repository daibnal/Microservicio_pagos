package duoc.dairys.pagos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import duoc.dairys.pagos.DTO.PagoDTO;
import duoc.dairys.pagos.model.Factura;
import duoc.dairys.pagos.model.MetodoPago;
import duoc.dairys.pagos.model.Pago;
import duoc.dairys.pagos.model.Transaccion;
import duoc.dairys.pagos.repository.FacturaRepositorio;
import duoc.dairys.pagos.repository.MtdoPagoRepositorio;
import duoc.dairys.pagos.repository.PagosRepositorio;
import duoc.dairys.pagos.repository.TransaccionRepositorio;

@Service
public class PagosServicio {
    @Autowired
    private PagosRepositorio pagosRepositorio;

    @Autowired
    private MtdoPagoRepositorio mtdoPagoRepositorio;

    @Autowired
    private TransaccionRepositorio transaccionRepositorio;

    @Autowired
    private FacturaRepositorio facturaRepositorio;


    //procesar pago
    public boolean procesarPago(PagoDTO dto){
        Pago pago = new Pago();

        pago.setMonto(dto.getMonto());
        pago.setFechaPago(dto.getFechaPago());
        pago.setEstado(dto.getEstado());

        MetodoPago metodo = mtdoPagoRepositorio.findById(dto.getIdMetodoPago()).orElse(null);
        Transaccion transaccion = transaccionRepositorio.findById(dto.getIdTransaccion()).orElse(null);
        Factura factura = facturaRepositorio.findById(dto.getIdFactura()).orElse(null);

        pago.setMetodoPago(metodo);
        pago.setTransaccion(transaccion);
        pago.setFactura(factura);

        pagosRepositorio.save(pago);
        return true;

    } 

    //confirmar pago
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

    //rechazar pago
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

    
    //cambiar estado del pago
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
