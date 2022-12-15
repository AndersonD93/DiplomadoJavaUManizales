package edu.umanizales.claro.services.front;

import edu.umanizales.claro.services.ClienteService;
import edu.umanizales.claro.services.IClienteService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RequestScoped
@Named
public class SaludarBean {

    @Inject
    private IClienteService clienteService;


    private String nombre;

    private String saludo = "Hola";

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSaludo() {
        return saludo;
    }

    public void obtenerSaludo(){
        this.saludo = this.getSaludo() + this.getNombre();
    }
}
