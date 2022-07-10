package servicios;

import jakarta.persistence.EntityManager;
import modelos.Requerimientos;
import repositorio.CrudRepositorio;
import repositorio.ProductoRepositorioImp;
import repositorio.RequerimientoRepositorioImp;
import util.JpaUtil;

import java.util.List;
import java.util.Optional;

public class RequerimientoServicesImp implements EntidadServices<Requerimientos>{

    private EntityManager em;
    private CrudRepositorio<Requerimientos> requerimientosCrudRepositorio;

    public RequerimientoServicesImp(EntityManager em) {
        this.em = em;
        this.requerimientosCrudRepositorio= new RequerimientoRepositorioImp(em);
    }

    @Override
    public List<Requerimientos> listar() {
        return requerimientosCrudRepositorio.listar();
    }

    @Override
    public Optional<Requerimientos> porId(Long id) {
        return Optional.ofNullable(requerimientosCrudRepositorio.porId(id));
    }

    @Override
    public void guardar(Requerimientos requerimientos) {
        try {
            em.getTransaction().begin();
            requerimientosCrudRepositorio.guardar(requerimientos);

            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Long id) {

            try{
                em.getTransaction().begin();
                requerimientosCrudRepositorio.eliminar(id);
                em.getTransaction().commit();

            }
            catch (Exception e){
                em.getTransaction().rollback();
                e.printStackTrace();
            }

        }

    }
