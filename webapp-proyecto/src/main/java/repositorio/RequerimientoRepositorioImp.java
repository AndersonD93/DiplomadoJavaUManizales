package repositorio;

import jakarta.persistence.EntityManager;
import modelos.Requerimientos;

import java.util.List;

public class RequerimientoRepositorioImp implements CrudRepositorio<Requerimientos>{
    EntityManager em;

    public RequerimientoRepositorioImp(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Requerimientos> listar() {
        return em.createQuery("select r from Requerimientos r ",Requerimientos.class).getResultList();
    }

    @Override
    public Requerimientos porId(Long id) {
        return em.find(Requerimientos.class,id);
    }

    @Override
    public void guardar(Requerimientos requerimientos) {
        if(requerimientos.getId()!=null && requerimientos.getId()>0){
            em.merge(requerimientos);
        }else {
            em.persist(requerimientos);
        }
    }

    @Override
    public void eliminar(Long id) {
        Requerimientos requerimientos = em.find(Requerimientos.class,id);
        em.remove(requerimientos);
    }
}
