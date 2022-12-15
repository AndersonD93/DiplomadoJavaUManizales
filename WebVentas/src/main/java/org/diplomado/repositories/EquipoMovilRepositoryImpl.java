package org.diplomado.repositories;

import jakarta.persistence.EntityManager;
import org.diplomado.models.EquipoMovil;
import org.diplomado.models.Venta;

import java.util.List;

public class EquipoMovilRepositoryImpl implements CrudRepository<EquipoMovil> {

    private EntityManager em;

    public EquipoMovilRepositoryImpl(EntityManager em) {
        this.em = em;
    }
    @Override
    public List<EquipoMovil> listar() {
        return em.createQuery("select p from EquipoMovil p",EquipoMovil.class).getResultList();
    }

    @Override
    public EquipoMovil porId(Long id) {
        return em.find(EquipoMovil.class,id);
    }

    @Override
    public void guardar(EquipoMovil equipoMovil) {
        if(equipoMovil.getId()!= null && equipoMovil.getId()>0){
            em.merge(equipoMovil);
        }else {
            em.persist(equipoMovil);
        }
    }

    @Override
    public void eliminar(Long id) {

        EquipoMovil equipoMovil = porId(id);
        em.remove(equipoMovil);
    }
}
