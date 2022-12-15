package edu.umanizales.claro.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteDTO {

    private Long id;

    private String nombre;

    private String cedula;

    private String celular;
}
