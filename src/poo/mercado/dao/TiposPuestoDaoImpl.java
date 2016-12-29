/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado.dao;

import java.util.ArrayList;
import java.util.List;
import poo.mercado.TipoPuesto;

/**
 *
 * @author joaquinleonelrobles
 */
public class TiposPuestoDaoImpl implements TiposPuestoDao {
    
    private final List<TipoPuesto> tiposPuesto;

    public TiposPuestoDaoImpl() {
        this.tiposPuesto = new ArrayList<>();
    }

    @Override
    public void guardar(TipoPuesto tipoPuesto) {
        tiposPuesto.add(tipoPuesto);
    }

    @Override
    public List<TipoPuesto> obtenerTodos() {
        return tiposPuesto;
    }
    
}
