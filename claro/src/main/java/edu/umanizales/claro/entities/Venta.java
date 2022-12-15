package edu.umanizales.claro.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Venta extends  EntityBase{

    @ManyToOne
    private Vendedor vendedor;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Smartphone smartphone;
}
