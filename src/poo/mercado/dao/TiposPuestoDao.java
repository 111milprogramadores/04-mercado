/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado.dao;

import java.util.List;
import poo.mercado.TipoPuesto;

/**
 *
 * @author joaquinleonelrobles
 */
public interface TiposPuestoDao {
    
    public void guardar (TipoPuesto tipoPuesto);
    
    public List<TipoPuesto> obtenerTodos ();
    
}
