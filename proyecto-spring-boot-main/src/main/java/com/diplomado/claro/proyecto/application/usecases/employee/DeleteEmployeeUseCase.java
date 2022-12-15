package com.diplomado.claro.proyecto.application.usecases.employee;

import com.diplomado.claro.proyecto.application.port.in.employee.DeleteEmployeeCommand;
import com.diplomado.claro.proyecto.application.port.out.employee.EmployeeOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteEmployeeUseCase implements DeleteEmployeeCommand {
    private EmployeeOutputPort employeeOutputPort;

    @Override
    public void execute(Long id) {
        employeeOutputPort.delete(id);
    }
}
