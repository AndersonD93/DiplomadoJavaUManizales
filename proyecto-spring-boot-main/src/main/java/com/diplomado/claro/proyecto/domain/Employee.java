package com.diplomado.claro.proyecto.domain;

import com.diplomado.claro.proyecto.adapters.external.entities.TypeEmployeeEntity;
import com.diplomado.claro.proyecto.config.constants.EnumStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private long id;
    private String identity;
    private String name;
    private String employeeCode;
    private TypeEmployeeEntity type;
    private EnumStatus status;
}
