/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado.dao;

import poo.mercado.Empleado;

/**
 *
 * @author joaquinleonelrobles
 */
public interface EmpleadosDao {
    
    public void guardar (Empleado empleado);
    
    public Empleado buscarPorNombreUsuario (String nombreUsuario);
    
}
