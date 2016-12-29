/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado.dao;

import java.util.List;
import poo.mercado.Contrato;
import poo.mercado.Puesto;

/**
 *
 * @author joaquinleonelrobles
 */
public interface ContratosDao {
    
    public void guardar (Contrato contrato);
    
    public List<Contrato> buscarPorPuesto (Puesto puesto);

    public int obtenerProximoNumero();
    
}
