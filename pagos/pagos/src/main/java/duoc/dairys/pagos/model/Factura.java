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
@Table(name = "factura")
public class Factura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactura;

    @Column(nullable = false, name = "folio_factura")
    @NotBlank(message = "El folio es obligatorio")
    private String folio;

    @Column(nullable = false, name = "monto_total")
    @NotNull(message = "El monto es obligatorio")
    private Double montoTotal;

    @Column(nullable = false, name = "correo_cliente")
    @NotNull(message = "El correo es obligatorio")
    private String correoCliente;

    @Column(nullable = false, name = "estado_factura")
    @NotBlank(message = "El estado es obligatorio")
    private String estado;



}
