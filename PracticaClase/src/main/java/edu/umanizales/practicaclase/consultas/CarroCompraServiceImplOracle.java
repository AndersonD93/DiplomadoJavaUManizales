package edu.umanizales.practicaclase.consultas;

import edu.umanizales.practicaclase.entities.CarroCompras;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CarroCompraServiceImplOracle implements CarroCompraService {

    @PersistenceContext(name = "comprasodbc")
    private EntityManager em;

    public CarroCompras findCarrosCompra(Long id){
        return em.find(CarroCompras.class, id);
    }

    public CarroCompras almacenarCarrosCompra(CarroCompras cc){
         em.persist(cc);
         return cc;
    }

    public CarroCompras actualizarCarrosCompra(CarroCompras cc){
        return em.merge(cc);
    }

    public void eliminarCarroCompras(CarroCompras cc){
        em.remove(cc);
    }
}
