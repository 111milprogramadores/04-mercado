/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import poo.mercado.Contrato;
import poo.mercado.Dimension;
import poo.mercado.Puesto;
import poo.mercado.TipoPuesto;

/**
 *
 * @author joaquinleonelrobles
 */
public class PuestosDaoImpl implements PuestosDao {
    
    private final List<Puesto> puestos;
    
    private final ContratosDao contratosDao;

    public PuestosDaoImpl(ContratosDao contratosDao) {
        this.puestos = new ArrayList<>();
        this.contratosDao = contratosDao;
    }

    @Override
    public void guardar(Puesto puesto) {
        puestos.add(puesto);
    }

    @Override
    public List<Puesto> buscarDisponiblesEnFechas(TipoPuesto tipoPuesto, Dimension dimension, Date fechaDesde, Date fechaHasta) {
        List<Puesto> retorno = new ArrayList<>();
        
        // iteramos sobre los puestos
        Iterator<Puesto> iter = puestos.iterator();
        while (iter.hasNext()) {
            Puesto p = iter.next();
            
            // chequeamos el tipo de puesto y la dimension
            if (p.esTipoYDimension(tipoPuesto, dimension)) {
                // en ese caso obtenemos los contratos
                List<Contrato> contratos = contratosDao.buscarPorPuesto(p);
                        
                // verificamos si el puesto esta disponible en esas fechas
                if (p.estaDisponible() || (p.estaAlquilado() && p.estaDisponibleEnFechas(fechaDesde, fechaHasta, contratos))) {
                    retorno.add (p);
                }
            }
        }
        
        return retorno;
    }
    
}
