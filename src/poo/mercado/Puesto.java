/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Candelaria
 */
public class Puesto {
    
    private Integer id;
    private int numero;
    private List<Lectura> lecturas;
    private Estado estado;
    private List<PrecioAlquiler> preciosAlquiler;

    /**
    * Constructor por Defecto
    */
    public Puesto() {
        preciosAlquiler= new ArrayList<>();
        lecturas = new ArrayList<>();
    }
    
    /**
    * Constructor con parámetros.
     * @param numero     
     * @param lecturas     
     * @param estado     
     * @param preciosAlquiler     
    */
    public Puesto(int numero, List<Lectura> lecturas, Estado estado, List<PrecioAlquiler> preciosAlquiler) {
        this.numero = numero;
        this.lecturas = lecturas;
        this.estado = estado;
        this.preciosAlquiler = preciosAlquiler;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<Lectura> getLecturas() {
        return lecturas;
    }

    public void setLecturas(List<Lectura> lecturas) {
        this.lecturas = lecturas;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }    

    public List<PrecioAlquiler> getPreciosAlquiler() {
        return preciosAlquiler;
    }

    public void setPreciosAlquiler(List<PrecioAlquiler> preciosAlquiler) {
        this.preciosAlquiler = preciosAlquiler;
    }
    
    public boolean esTipoYDimension (TipoPuesto tipoPuesto, Dimension dimension) {
        PrecioAlquiler precioVigente = obtenerPrecioVigente();
        
        return precioVigente.getTipoPuesto().equals(tipoPuesto) && precioVigente.getDimension().equals(dimension);
    }
    
    public boolean estaAlquilado () {
        return estado.esAlquilado();
    }
    
    public boolean estaDisponible () {
        return estado.esDisponible();
    }

    public boolean estaDisponibleEnFechas(Date fechaDesde, Date fechaHasta, List<Contrato> contratos) {
        boolean disponible = true;
        
        Calendar desde = Calendar.getInstance();
        desde.setTime(fechaDesde);
        
        Calendar hasta = Calendar.getInstance();
        hasta.setTime(fechaHasta);
        
        Iterator<Contrato> iter = contratos.iterator();
        while (iter.hasNext()) {
            Contrato contrato = iter.next();
            
            Calendar contratoDesde = Calendar.getInstance();
            contratoDesde.setTime(contrato.getFechaInicioContrato());
            
            Calendar contratoHasta = Calendar.getInstance();
            contratoHasta.setTime(contrato.getFechaFinContrato());
            
            if (!((desde.before(contratoDesde) && hasta.before(contratoDesde)) || (desde.after(contratoHasta) && hasta.after(contratoHasta)))) {
                disponible = false;
                break;
            }
        }
        
        return disponible;
    }
    
    public PrecioAlquiler obtenerPrecioVigente () {
        PrecioAlquiler vigente = null;
        
        // recorremos buscando la mayor fecha menor o igual a hoy
        Iterator<PrecioAlquiler> iter = preciosAlquiler.iterator();
        while (iter.hasNext()) {
            PrecioAlquiler actual = iter.next();
            
            // si esta vigente lo retornamos
            if (actual.estaVigente()) {
                vigente = actual;
                break;
            }
        }
        
        return vigente;
    }

    /**
     * Obtenemos la ultima lectura del medidor, suponiendo que se encuentran
     * ordenadas por fecha de forma ascendente.
     * 
     * @return 
     */
    public Lectura obtenerUltimaLectura() {
        Lectura ultima = null;
        
        if (lecturas.size() > 0) {
            ultima = lecturas.get(lecturas.size() - 1);
        }
        
        return ultima;
    }

    public void alquilar(Estado alquilado) {
        this.setEstado(alquilado);
    }
}
