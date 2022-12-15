package edu.umanizales.claro.entities;

import jakarta.persistence.*;
import lombok.Data;



@MappedSuperclass
@Data
public class Persona extends EntityBase{

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "cedula")
    private String cedula;
}
