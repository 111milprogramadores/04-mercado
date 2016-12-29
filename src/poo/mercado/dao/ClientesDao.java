/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado.dao;

import poo.mercado.Cliente;

/**
 *
 * @author joaquinleonelrobles
 */
public interface ClientesDao {
    
    public void guardar (Cliente cliente);
    
    public Cliente buscarPorNombre (String nombre);
    
}
