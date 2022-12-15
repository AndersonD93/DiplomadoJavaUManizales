package org.diplomado.repositories;

import jakarta.persistence.EntityManager;
import org.diplomado.models.Venta;


import java.util.List;

public class VentaRepositoryImpl implements CrudRepository<Venta> {
    private EntityManager em;

    public VentaRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Venta> listar() {
        return em.createQuery("select p from venta p",Venta.class).getResultList();
    }

    @Override
    public Venta porId(Long id) {
        return em.find(Venta.class,id);
    }

    @Override
    public void guardar(Venta productos) {
        if(productos.getId()!= null && productos.getId()>0){
            em.merge(productos);
        }else {
            em.persist(productos);
        }

    }
    @Override
    public void eliminar(Long id) {
        Venta productos = porId(id);
        em.remove(productos);

    }

}
