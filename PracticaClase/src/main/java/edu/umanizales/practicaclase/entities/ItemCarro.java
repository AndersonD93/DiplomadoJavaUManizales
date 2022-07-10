package edu.umanizales.practicaclase.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ItemCarro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private CarroCompras carroCompras;
}
