package com.diplomado.claro.proyecto.adapters.external.jpa;

import com.diplomado.claro.proyecto.adapters.external.entities.EmployeeEntity;
import com.diplomado.claro.proyecto.application.port.out.employee.EmployeeOutputPort;
import com.diplomado.claro.proyecto.config.constants.EnumStatus;
import com.diplomado.claro.proyecto.domain.Employee;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class EmployeeAdapter implements EmployeeOutputPort {
    private ModelMapper modelmapper;
    private IEmployeeRepository employeeRepository;

    @Override
    public void create(Employee employee) {
        employeeRepository.save(modelmapper.map(employee, EmployeeEntity.class));
    }

    @Override
    public Employee findByIdentity(String identity) {
        return modelmapper.map(employeeRepository.findByIdentityAndStatus(identity, EnumStatus.ACTIVE), Employee.class);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll().stream()
                .map(employeeEntity -> modelmapper.map(employeeEntity, Employee.class))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Employee employee) {
        try {
            EmployeeEntity employeeFromDB = employeeRepository.getReferenceById(employee.getId());
            employeeFromDB.setName(employee.getName());
            employeeFromDB.setEmployeeCode(employee.getEmployeeCode());
            employeeFromDB.setIdentity(employee.getIdentity());
            employeeFromDB.setType(employee.getType());
            employeeFromDB.setStatus(employee.getStatus());
            employeeRepository.save(employeeFromDB);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
