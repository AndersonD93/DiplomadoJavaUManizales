package org.diplomado.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
public class EquipoMovil {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

    @Column
    private String nombre;

    @Column
    private String marca;

    @Column
    private BigDecimal precio;

    @Column
    private Integer cantidad;


}
