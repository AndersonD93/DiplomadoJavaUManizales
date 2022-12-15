package edu.umanizales.claro.entities;

import edu.umanizales.claro.entities.Persona;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Cliente extends Persona {

    @Column(name = "celular")
    private String celular;
}
