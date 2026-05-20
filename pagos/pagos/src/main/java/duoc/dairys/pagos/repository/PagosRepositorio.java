package duoc.dairys.pagos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import duoc.dairys.pagos.model.Pagos;

public interface PagosRepositorio extends JpaRepository<Pagos, Long> {
    
}
