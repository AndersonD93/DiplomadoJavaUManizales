package org.diplomado.services;

import jakarta.persistence.EntityManager;
import org.diplomado.models.EquipoMovil;
import org.diplomado.repositories.CrudRepository;
import org.diplomado.repositories.EquipoMovilRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class EquipoMovilServicesImpl implements EntidadServices<EquipoMovil> {
    private EntityManager em;// para manejar los commit y rollback
    private CrudRepository<EquipoMovil> equipoMovilCrudRepository;

    public EquipoMovilServicesImpl(EntityManager em) {
        this.em = em;
        this.equipoMovilCrudRepository = new EquipoMovilRepositoryImpl(em);
    }

    @Override
    public List<EquipoMovil> listar() {
        return equipoMovilCrudRepository.listar();
    }

    @Override
    public Optional<EquipoMovil> porId(Long id) {
        return Optional.ofNullable(equipoMovilCrudRepository.porId(id));
    }

    @Override
    public void guardar(EquipoMovil equipoMovil) {

        try {
            em.getTransaction().begin();
            equipoMovilCrudRepository.guardar(equipoMovil);

            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }

    }

    @Override
    public void eliminar(Long id) {

        try {
            em.getTransaction().begin();
            equipoMovilCrudRepository.eliminar(id);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }

    }
}