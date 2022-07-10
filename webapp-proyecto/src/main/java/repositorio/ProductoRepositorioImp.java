package repositorio;

import jakarta.persistence.EntityManager;
import modelos.Productos;

import java.util.List;

public class ProductoRepositorioImp implements CrudRepositorio<Productos> {
    private EntityManager em;

    public ProductoRepositorioImp(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Productos> listar() {
        return em.createQuery("select p from productos p",Productos.class).getResultList();
    }

    @Override
    public Productos porId(Long id) {
        return em.find(Productos.class,id);
    }

    @Override
    public void guardar(Productos productos) {
        if(productos.getId()!= null && productos.getId()>0){
            em.merge(productos);
        }else {
            em.persist(productos);
        }

    }
    @Override
    public void eliminar(Long id) {
        Productos productos = porId(id);
        em.remove(productos);

    }
}
