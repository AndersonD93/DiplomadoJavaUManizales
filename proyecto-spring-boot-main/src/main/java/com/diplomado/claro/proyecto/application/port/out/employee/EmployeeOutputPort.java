package com.diplomado.claro.proyecto.application.port.out.employee;

import com.diplomado.claro.proyecto.domain.Employee;

import java.util.List;

public interface EmployeeOutputPort {
    void create(Employee employee);
    Employee findByIdentity(String identity);
    List<Employee> findAll();
    void update(Employee employee);
    void delete(Long id);
}
