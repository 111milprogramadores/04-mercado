/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado.dao;

import poo.mercado.Sector;

/**
 *
 * @author joaquinleonelrobles
 */
public interface SectoresDao {
    
    public void guardar (Sector sector);
    
    public Sector buscarPorNombre (String nombre);
    
}
