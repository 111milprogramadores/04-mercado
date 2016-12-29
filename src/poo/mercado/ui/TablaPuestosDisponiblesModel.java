/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado.ui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import poo.mercado.Puesto;

/**
 *
 * @author joaquinleonelrobles
 */
public class TablaPuestosDisponiblesModel extends AbstractTableModel {
    
    private static final String[] COLUMNAS = { "Nro.", "Sector", "Superficie", "Alquiler" };
    
    private List<Puesto> puestos;

    public TablaPuestosDisponiblesModel (List<Puesto> puestos) {
        super();
        this.puestos = puestos;
    }

    public TablaPuestosDisponiblesModel() {
        super();
        this.puestos = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return puestos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Object retorno = null;
        Puesto puesto = puestos.get(fila);
        
        // según la columna deseada obtenemos el valor a mostrar
        switch (columna) {
            case 0:
                retorno = puesto.getNumero();
                break;
            case 1:
                retorno = puesto.obtenerPrecioVigente().getSector();
                break;
            case 2:
                retorno = puesto.obtenerPrecioVigente().getDimension().calcularMetrosCuadrados();
                break;
            case 3:
                retorno = puesto.obtenerPrecioVigente().getPrecio();
                break;
        }
        
        return retorno;
    }
    
    @Override
    public String getColumnName(int index) {
        return COLUMNAS[index];
    }
    
    public Puesto obtenerPuestoEn (int fila) {
        return puestos.get(fila);
    }

    public void setPuestos(List<Puesto> puestos) {
        this.puestos = puestos;
    }
    
}
