package com.diplomado.claro.proyecto.application.usecases.employee;

import com.diplomado.claro.proyecto.application.port.in.employee.FindAllEmployeesQuery;
import com.diplomado.claro.proyecto.application.port.out.employee.EmployeeOutputPort;
import com.diplomado.claro.proyecto.domain.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllEmployeesUseCase implements FindAllEmployeesQuery {
    private final EmployeeOutputPort employeeRepository;

    @Override
    public List<Employee> execute() {
        return employeeRepository.findAll();
    }
}
