package com.diplomado.claro.proyecto.adapters.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TypeEmployeeDTO {
    private long id;
    private String name;
}
