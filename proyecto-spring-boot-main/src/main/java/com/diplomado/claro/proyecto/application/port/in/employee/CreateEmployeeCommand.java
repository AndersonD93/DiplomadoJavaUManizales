package com.diplomado.claro.proyecto.application.port.in.employee;

import com.diplomado.claro.proyecto.domain.Employee;

public interface CreateEmployeeCommand {
    void execute(Employee employee);
}
