package com.diplomado.claro.proyecto.adapters.external.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "employee")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class EmployeeEntity extends PersonEntity {
    private String employeeCode;
    @OneToOne
    @JoinColumn(name = "type_employee_id", referencedColumnName = "id")
    private TypeEmployeeEntity type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
