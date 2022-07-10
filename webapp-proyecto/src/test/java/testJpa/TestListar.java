package testJpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import modelos.Productos;
import util.JpaUtil;

import java.util.List;

public class TestListar {

    public static void main(String[] args) {


    EntityManager em = JpaUtil.getEntityManager();

    Query query= em.createQuery("select p from productos p", Productos.class);
    List<Productos> productosList = query.getResultList();
        System.out.println(productosList);
        em.close();;
    }
}
