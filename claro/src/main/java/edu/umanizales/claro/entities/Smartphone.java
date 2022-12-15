package edu.umanizales.claro.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Data
public class Smartphone extends EntityBase{


    @Column(name = "marca")
    private String marca;

    @Column(name = "precio_compra")
    private BigDecimal precioCompra;

    @Column(name = "cantidad")
    private BigInteger cantidad;

}
