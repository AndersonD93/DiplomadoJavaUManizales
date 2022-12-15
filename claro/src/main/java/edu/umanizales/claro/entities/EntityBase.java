package edu.umanizales.claro.entities;

import edu.umanizales.claro.entities.Enum.EnumEstado;
import jakarta.persistence.*;
import lombok.Data;

@MappedSuperclass
@Data
public class EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "estado", columnDefinition = "varchar(32) default 'ACTIVO'")
    @Enumerated(EnumType.STRING)
    private EnumEstado estado = EnumEstado.ACTIVO;
}
