package org.diplomado.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data

public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(optional = false)
    @JoinColumn(name = "equipo_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_equipo_id"))
    private EquipoMovil producto;


    @ManyToOne(optional = false)
    @JoinColumn(name = "empleado_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_venta_empleado_id"))
    private Empleado empleado;



    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_venta_cliente_id"))
    private Cliente cliente;

    @Column(nullable = true)
    private String ciudad;

}
