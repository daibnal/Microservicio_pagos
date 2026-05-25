package duoc.dairys.pagos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import duoc.dairys.pagos.model.Pago;

public interface PagosRepositorio extends JpaRepository<Pago, Long> {
    
}
