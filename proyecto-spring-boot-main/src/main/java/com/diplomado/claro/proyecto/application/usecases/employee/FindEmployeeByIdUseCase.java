package com.diplomado.claro.proyecto.application.usecases.employee;

import com.diplomado.claro.proyecto.application.port.in.employee.FindEmployeeByIdentityQuery;
import com.diplomado.claro.proyecto.application.port.out.employee.EmployeeOutputPort;
import com.diplomado.claro.proyecto.domain.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindEmployeeByIdUseCase implements FindEmployeeByIdentityQuery {
    private EmployeeOutputPort employeeOutputPort;

    @Override
    public Employee execute(String identity) {
        return employeeOutputPort.findByIdentity(identity);
    }
}
