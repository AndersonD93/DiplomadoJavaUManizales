package com.aduran.apiservlet.webapp.headers.services;

import com.aduran.apiservlet.webapp.headers.models.Producto;

import java.util.Arrays;
import java.util.List;

public class ProductoServiceImpl implements ProductoService{

    @Override
    public List<Producto> listar() {
        return Arrays.asList(new Producto(1l,"notebook","computacion",175000),
        new Producto(2l,"mesa escritorio","oficina",100000),
        new Producto(3l,"teclado mecanico", "computacion",40000));
    }
}
