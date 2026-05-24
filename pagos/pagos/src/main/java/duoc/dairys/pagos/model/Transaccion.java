package duoc.dairys.pagos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaccion")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaccion;

    @Column(nullable = false, name = "codigo_autorizacion")
    @NotBlank(message = "El codigo es obligatorio")
    private String codigoAutorizacion;
    
    @Column(nullable = false,  name = "monto_transaccion")
    @NotNull(message = "El monto es obligatorio")
    private Double monto;

    @Column(nullable = false, name = "estado_transaccion")
    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    
}
