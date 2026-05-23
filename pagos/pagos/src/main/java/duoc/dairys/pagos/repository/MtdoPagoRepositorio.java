package duoc.dairys.pagos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import duoc.dairys.pagos.model.MetodoPago;

public interface MtdoPagoRepositorio extends JpaRepository<MetodoPago, Long> {
    
}
