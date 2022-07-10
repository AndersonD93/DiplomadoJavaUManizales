package testJpa;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestJPA {

    @Test
    public void testCreacionBD(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("requerimientos");
        EntityManager em= emf.createEntityManager();
        assertNotNull(em);
        em.close();
    }
}
