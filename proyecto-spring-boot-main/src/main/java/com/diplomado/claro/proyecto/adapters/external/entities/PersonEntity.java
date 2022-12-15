package com.diplomado.claro.proyecto.adapters.external.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PersonEntity extends BaseEntity {
    private String identity;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PersonEntity that = (PersonEntity) o;
        return identity != null && Objects.equals(identity, that.identity) && name != null && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
