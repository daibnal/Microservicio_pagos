package duoc.dairys.pagos.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "pagos")
public class Pagos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPago;

    @OneToOne(mappedBy = "pagos", cascade = CascadeType.ALL, orphanRemoval = true)
    private Long idPedido;

    @OneToOne(mappedBy = "pagos", cascade = CascadeType.ALL, orphanRemoval = true)
    private Long idCliente;
    private Double monto;
    private LocalDateTime fechaPago;
    private String estado;

    public Pagos(Long idPago, Long idPedido, Long idCliente, Double monto, LocalDateTime fechaPago, String estado){
        this.idPago = idPago;
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.estado = estado;
    }



    
}
