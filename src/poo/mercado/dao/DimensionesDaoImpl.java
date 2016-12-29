/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado.dao;

import java.util.ArrayList;
import java.util.List;
import poo.mercado.Dimension;

/**
 *
 * @author joaquinleonelrobles
 */
public class DimensionesDaoImpl implements DimensionesDao {
    
    private final List<Dimension> dimensiones;

    public DimensionesDaoImpl() {
        this.dimensiones = new ArrayList<>();
    }

    @Override
    public void guardar(Dimension dimension) {
        dimensiones.add(dimension);
    }

    @Override
    public List<Dimension> obtenerTodas() {
        return dimensiones;
    }
    
}
