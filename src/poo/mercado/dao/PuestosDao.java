/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado.dao;

import java.util.Date;
import java.util.List;
import poo.mercado.Dimension;
import poo.mercado.Puesto;
import poo.mercado.TipoPuesto;

/**
 *
 * @author joaquinleonelrobles
 */
public interface PuestosDao {
    
    public void guardar (Puesto puesto);
    
    public List<Puesto> buscarDisponiblesEnFechas (TipoPuesto tipoPuesto, Dimension dimension, Date fechaDesde, Date fechaHasta);
    
}
