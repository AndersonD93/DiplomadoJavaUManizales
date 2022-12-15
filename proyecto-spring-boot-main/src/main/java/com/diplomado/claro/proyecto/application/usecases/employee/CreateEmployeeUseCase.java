package com.diplomado.claro.proyecto.application.usecases.employee;

import com.diplomado.claro.proyecto.application.port.in.employee.CreateEmployeeCommand;
import com.diplomado.claro.proyecto.application.port.out.employee.EmployeeOutputPort;
import com.diplomado.claro.proyecto.domain.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateEmployeeUseCase implements CreateEmployeeCommand {
    private EmployeeOutputPort employeeOutputPort;

    @Override
    public void execute(Employee employee) {
        employeeOutputPort.create(employee);
    }
}
