package org.diplomado.models;

import jakarta.persistence.*;
import lombok.Data;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
public class Empleado {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column(unique = true)
    private Double identificacion;


    @Column
    @Enumerated(value=EnumType.STRING)
    private TipoVendedorEnum vendedor;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL)
    private List<Venta> ventas;


}
