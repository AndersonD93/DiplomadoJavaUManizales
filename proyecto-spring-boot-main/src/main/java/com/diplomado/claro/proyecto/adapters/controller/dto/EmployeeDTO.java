package com.diplomado.claro.proyecto.adapters.controller.dto;

import com.diplomado.claro.proyecto.config.constants.EnumStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String name;
    private String identity;
    private String employeeCode;
    private TypeEmployeeDTO type;
    private EnumStatus status;
}
