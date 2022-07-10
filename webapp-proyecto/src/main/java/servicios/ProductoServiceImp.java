package servicios;

import jakarta.persistence.EntityManager;
import modelos.Productos;
import repositorio.CrudRepositorio;
import repositorio.ProductoRepositorioImp;

import java.util.List;
import java.util.Optional;

public class ProductoServiceImp implements EntidadServices<Productos> {
    private EntityManager em;// para manejar los commit y rollback
    private CrudRepositorio <Productos> productosCrudRepositorio;

    public ProductoServiceImp(EntityManager em) {
        this.em = em;
        this.productosCrudRepositorio=new ProductoRepositorioImp(em);
    }

    @Override
    public List<Productos> listar() {
        return productosCrudRepositorio.listar();
    }

    @Override
    public Optional<Productos> porId(Long id) {
        return Optional.ofNullable(productosCrudRepositorio.porId(id));
    }

    @Override
    public void guardar(Productos productos) {

        try{
            em.getTransaction().begin();
            productosCrudRepositorio.guardar(productos);

            em.getTransaction().commit();

        }
        catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }

    }

    @Override
    public void eliminar(Long id) {

        try{
            em.getTransaction().begin();
            productosCrudRepositorio.eliminar(id);
            em.getTransaction().commit();

        }
        catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }

    }

    }

