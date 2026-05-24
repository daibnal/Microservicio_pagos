package duoc.dairys.pagos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import duoc.dairys.pagos.model.Factura;

public interface FacturaRepositorio extends JpaRepository<Factura, Long> {
    
}
