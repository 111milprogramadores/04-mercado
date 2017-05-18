/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import poo.mercado.Cliente;

/**
 *
 * @author joaquinleonelrobles
 */
public class ClientesDaoImpl implements ClientesDao {
    
    private final List<Cliente> clientes;

    public ClientesDaoImpl() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public void guardar(Cliente cliente) {
        this.clientes.add(cliente);
    }

    @Override
    public Cliente buscarPorRazonSocial(String nombre) {
        Cliente retorno = null;
        
        Iterator<Cliente> iter = clientes.iterator();
        while (iter.hasNext()) {
            Cliente actual = iter.next();
                    
            if (actual.getRazonSocial().equals(nombre)) {
                retorno = actual;
                break;
            }
        }
        
        return retorno;
    }
    
}
