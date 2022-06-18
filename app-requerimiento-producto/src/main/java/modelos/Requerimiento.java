package modelos;

import java.util.Date;

public class Requerimiento {
    private Date fecha;
    private Boolean estado;
    private int precio;

    public Requerimiento(Date fecha, int precio) {
        this.fecha = fecha;
        this.precio = precio;
    }
}
