package edu.umanizales.test;

import edu.umanizales.practicaclase.entities.CarroCompras;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestJPA {

    @Test
    public void testCreacionBD(){
        //Arrange
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("compras");
        //Act
        EntityManager em = emf.createEntityManager();
        //Assert
        assertNotNull(em);
        em.close();
    }
}
