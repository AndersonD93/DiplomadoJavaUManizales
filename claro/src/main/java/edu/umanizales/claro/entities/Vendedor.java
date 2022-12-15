package edu.umanizales.claro.entities;

import edu.umanizales.claro.entities.Enum.EnumTipoVendedor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Entity
@Data
public class Vendedor extends Persona{

    @Column(name = "codigo_empleado")
    private String codigoEmpleado;

    @Column(name = "tipo_vendedor")
    @Enumerated(EnumType.STRING)
    private EnumTipoVendedor tipoVendedor;

    @Column(name = "ciudad")
    private String ciudad;
}
