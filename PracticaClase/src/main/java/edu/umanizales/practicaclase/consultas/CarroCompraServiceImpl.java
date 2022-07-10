package edu.umanizales.practicaclase.consultas;

import edu.umanizales.practicaclase.controller.CarroCompraServlet;
import edu.umanizales.practicaclase.entities.CarroCompras;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CarroCompraServiceImpl implements CarroCompraService {

    @PersistenceContext(name = "compras")
    private EntityManager em;

    public CarroCompras findCarrosCompra(Long id){
       Query q =  em.createQuery("SELECT c FROM CarroCompras WHERE carroCompras.id = :id");
       q.setParameter("id", id);
       CarroCompras cc = (CarroCompras) q.getSingleResult();
       return cc;
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
