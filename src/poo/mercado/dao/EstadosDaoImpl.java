/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import poo.mercado.Estado;

/**
 *
 * @author joaquinleonelrobles
 */
public class EstadosDaoImpl implements EstadosDao {
    
    private final List<Estado> estados;

    public EstadosDaoImpl() {
        this.estados = new ArrayList<>();
    }

    @Override
    public void guardar(Estado estado) {
        this.estados.add(estado);
    }

    @Override
    public Estado buscarPorNombre(String nombre) {
        Estado encontrado = null;
        
        Iterator<Estado> iter = estados.iterator();
        while (iter.hasNext()) {
            Estado actual = iter.next();
            
            if (actual.getNombre().equals(nombre)) {
                encontrado = actual;
                break;
            }
        }
        
        return encontrado;
    }

    @Override
    public List<Estado> obtenerTodos() {
        return this.estados;
    }
    
}
