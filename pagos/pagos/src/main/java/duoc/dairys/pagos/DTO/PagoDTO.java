package duoc.dairys.pagos.DTO;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagoDTO {

    @NotNull
    private Double monto;

    @NotNull
    private LocalDateTime fechaPago;

    @NotBlank
    private String estado;

    @NotNull
    private Long idMetodoPago;

    @NotNull
    private Long idTransaccion;

    @NotNull
    private Long idFactura;
}
