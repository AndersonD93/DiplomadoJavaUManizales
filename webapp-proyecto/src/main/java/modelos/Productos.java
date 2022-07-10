package modelos;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity (name="productos")
@Data
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="cantidadOfertada")
    private int cantidadOfertada;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name="nombre")
    private String nombre;

    @Column(name="idReq")
    private int idReq;


}

