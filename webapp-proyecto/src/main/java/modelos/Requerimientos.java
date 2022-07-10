package modelos;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Requerimientos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name="fechaInicial")
    private LocalDate fechaInicial;

    @Column(name="fechaFinal")
    private LocalDate fechaFinal;

    @Column(name="precio")
    private BigDecimal precio;

}
