package org.diplomado.services;

import java.util.List;
import java.util.Optional;

public interface EntidadServices <T> {

    List<T> listar();
    Optional<T> porId(Long id);
    void guardar(T t);
    void eliminar(Long id);
}
