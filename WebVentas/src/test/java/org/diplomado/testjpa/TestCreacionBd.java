package org.diplomado.testjpa;

import jakarta.persistence.EntityManager;
import org.diplomado.utils.Conexion;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TestCreacionBd {

    @Test
    public void crearbd() {

        EntityManager em = Conexion.getEntityManager();
        assertNotNull(em);
        em.close();
    }
}
