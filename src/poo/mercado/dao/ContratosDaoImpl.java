/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import poo.mercado.Contrato;
import poo.mercado.Puesto;

/**
 *
 * @author joaquinleonelrobles
 */
public class ContratosDaoImpl implements ContratosDao {
    
    private final List<Contrato> contratos;

    public ContratosDaoImpl() {
        this.contratos = new ArrayList<>();
    }

    @Override
    public void guardar(Contrato contrato) {
        this.contratos.add(contrato);
    }

    @Override
    public List<Contrato> buscarPorPuesto(Puesto puesto) {
        List<Contrato> retorno = new ArrayList<>();
        
        Iterator<Contrato> iter = this.contratos.iterator();
        while (iter.hasNext()) {
            Contrato actual = iter.next();
            
            // si corresponde al puesto
            if (actual.getPuesto().equals(puesto)) {
                retorno.add(actual);
            }
        }
        
        return retorno;
    }

    @Override
    public int obtenerProximoNumero() {
        return contratos.size() + 1;
    }
    
}
