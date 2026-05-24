package duoc.dairys.pagos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import duoc.dairys.pagos.model.Transaccion;

@Repository
public interface TransaccionRepositorio extends JpaRepository<Transaccion, Long> {
    
}
