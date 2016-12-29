/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado.ui;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import poo.mercado.Puesto;

/**
 *
 * @author joaquinleonelrobles
 */
public class PuestosTableModelListener implements ListSelectionListener {
    
    private final PantallaAlquilerDePuesto pantalla;

    public PuestosTableModelListener(PantallaAlquilerDePuesto pantalla) {
        this.pantalla = pantalla;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        // obtenemos el puesto seleccionado
        Puesto puesto = pantalla.obtenerPuestoSeleccionado();
        String lectura = "";
        
        // si corresponde mostrar la ultima lectura
        if (puesto != null && puesto.obtenerUltimaLectura() != null) {
            lectura = puesto.obtenerUltimaLectura().getLectura();
        }
        
        pantalla.getLblUltimaLectura().setText(lectura);
    }
    
}
