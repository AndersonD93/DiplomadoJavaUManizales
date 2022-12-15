package com.diplomado.claro.proyecto.adapters.external.jpa;

import com.diplomado.claro.proyecto.adapters.external.entities.EmployeeEntity;
import com.diplomado.claro.proyecto.config.constants.EnumStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    EmployeeEntity findByIdentityAndStatus(String identity, EnumStatus enumEstado);
}
