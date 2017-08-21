/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado.dao;

import java.util.List;
import poo.mercado.Estado;

/**
 *
 * @author joaquinleonelrobles
 */
public interface EstadosDao {
    
    public void guardar (Estado estado);
    
    public Estado buscarPorNombre (String nombre);

    public List<Estado> obtenerTodos();
    
}
