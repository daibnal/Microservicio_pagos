package duoc.dairys.pagos.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pago")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPago;

    @Column(name = "pedido_id")
    private Long idPedido;

    @Column(name = "cliente_id")
    private Long idCliente;

    @Min(0)
    @NotNull(message = "El monto es obligatorio")
    @Column(name = "monto_pago")
    private Double monto;

    @NotNull(message = "La fecha es obligatoria")
    @Column(name = "fecha_pago")
    private LocalDateTime fechaPago;

    @NotBlank(message = "El estado no puede estar vacio")
    @Column(name = "estado_pago")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "metodo_pago_id")
    private MetodoPago metodoPago;

    @ManyToOne
    @JoinColumn(name = "transaccion_id")
    private Transaccion transaccion;

    @ManyToOne
    @JoinColumn(name = "factura_id")
    private Factura factura;

    
}
