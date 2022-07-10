package edu.umanizales.practicaclase.consultas;

import edu.umanizales.practicaclase.entities.CarroCompras;

public interface CarroCompraService {

    public CarroCompras findCarrosCompra(Long id);


    public CarroCompras almacenarCarrosCompra(CarroCompras cc);

    public CarroCompras actualizarCarrosCompra(CarroCompras cc);


    public void eliminarCarroCompras(CarroCompras cc);

}
