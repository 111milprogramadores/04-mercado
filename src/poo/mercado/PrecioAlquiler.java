/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Candelaria
 */
public class PrecioAlquiler {
    private Date fechaVigencia;
    private BigDecimal precio;
    private Sector sector;
    private Dimension dimension;
    private TipoPuesto tipoPuesto;

    /**
    * Constructor por Defecto
    */
    public PrecioAlquiler() {
    }

    /**
    * Constructor con parámetros, sin incluir atributos referenciales.
     * @param fechaVigencia    
     * @param precio     
    */
    public PrecioAlquiler(Date fechaVigencia, BigDecimal precio) {
        this.fechaVigencia = fechaVigencia;
        this.precio = precio;
    }

     /**
    * Constructor con parámetros, con todos los atributos de la clase PrecioAlquiler.
     * @param fechaVigencia    
     * @param precio     
     * @param sector     
     * @param dimension     
     * @param tipoPuesto     
    */
    public PrecioAlquiler(Date fechaVigencia, BigDecimal precio, Sector sector, Dimension dimension, TipoPuesto tipoPuesto) {
        this.fechaVigencia = fechaVigencia;
        this.precio = precio;
        this.sector = sector;
        this.dimension = dimension;
        this.tipoPuesto = tipoPuesto;
    }
    
    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(Date fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public TipoPuesto getTipoPuesto() {
        return tipoPuesto;
    }

    public void setTipoPuesto(TipoPuesto tipoPuesto) {
        this.tipoPuesto = tipoPuesto;
    }
    
}
