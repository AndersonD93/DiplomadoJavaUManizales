package com.diplomado.claro.proyecto.adapters.controller;

import com.diplomado.claro.proyecto.adapters.controller.dto.EmployeeDTO;
import com.diplomado.claro.proyecto.adapters.controller.dto.Response;
import com.diplomado.claro.proyecto.application.port.in.employee.*;
import com.diplomado.claro.proyecto.domain.Employee;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.diplomado.claro.proyecto.config.constants.Constant.*;

@RestController
@RequestMapping({"api/v1/employee"})
@CrossOrigin(
        origins = {"*"},
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT}
)
@AllArgsConstructor
public class EmployeeController {
    private final ModelMapper modelMapper;
    private final CreateEmployeeCommand createEmployeeService;
    private final FindEmployeeByIdentityQuery findByIdentityService;
    private final FindAllEmployeesQuery findAllEmployeesService;
    private final UpdateEmployeeCommand updateEmployeeService;
    private final DeleteEmployeeCommand deleteEmployeeService;

    @PostMapping
    public ResponseEntity<Response> createEmployee(@RequestBody EmployeeDTO employee) {
        createEmployeeService.execute(modelMapper.map(employee, Employee.class));
        return new ResponseEntity<>(new Response(MSG_EMPLOYEE_CREATED), HttpStatus.CREATED);
    }

    @GetMapping("/by/identity/{identity}")
    public ResponseEntity<Response> getEmployee(@PathVariable String identity) {
        return new ResponseEntity<>(Response.builder()
                .data(modelMapper.map(findByIdentityService.execute(String.valueOf(identity)), EmployeeDTO.class)).build(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Response> getAllEmployees() {
        return new ResponseEntity<>(Response.builder().data(findAllEmployeesService.execute()).build(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Response> updateEmployee(@RequestBody EmployeeDTO employee) {
        updateEmployeeService.execute(modelMapper.map(employee, Employee.class));
        return new ResponseEntity<>(new Response(MSG_EMPLOYEE_UPDATED), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteEmployee(@PathVariable Long id) {
        deleteEmployeeService.execute(id);
        return new ResponseEntity<>(new Response(MSG_EMPLOYEE_DELETED), HttpStatus.OK);
    }
}