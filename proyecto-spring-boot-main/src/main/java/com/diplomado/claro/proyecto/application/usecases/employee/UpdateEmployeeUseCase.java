package com.diplomado.claro.proyecto.application.usecases.employee;

import com.diplomado.claro.proyecto.application.port.in.employee.UpdateEmployeeCommand;
import com.diplomado.claro.proyecto.application.port.out.employee.EmployeeOutputPort;
import com.diplomado.claro.proyecto.domain.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateEmployeeUseCase implements UpdateEmployeeCommand {
    private EmployeeOutputPort employeeOutputPort;

    @Override
    public void execute(Employee employee) {
        employeeOutputPort.update(employee);
    }
}
