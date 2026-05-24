package duoc.dairys.pagos.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "El monto es obligatorio")
    private Double monto;

     @NotNull(message = "La fecha es obligatoria")
    private LocalDateTime fechaPago;

    @NotBlank(message = "El estado no puede estar vacio")
    private String estado;

    @OneToOne
    @JoinColumn(name = "meotod_pago_id")
    private MetodoPago metodoPago;

    @OneToOne
    @JoinColumn(name = "transaccion_id")
    private Transaccion transaccion;

    @OneToOne
    @JoinColumn(name = "factura_id")
    private Factura factura;


    public Pagos(Long idPago, Long idPedido, Long idCliente, Double monto, LocalDateTime fechaPago, String estado){
        this.idPago = idPago;
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.estado = estado;
    }



    
}
