package com.diplomado.claro.proyecto.application.port.in.employee;

import com.diplomado.claro.proyecto.domain.Employee;

import java.util.List;

public interface FindAllEmployeesQuery {
    List<Employee> execute();
}
