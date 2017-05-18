/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado;

import java.util.Date;

/**
 *
 * @author Candelaria
 */
public class Lectura {
    
    private Integer id;
    private String lectura;
    private Date fechaCaptura;

    /**
    * Constructor por Defecto
    */
    public Lectura() {
    }

    /**
    * Constructor con parámetros.
     * @param lectura     
     * @param fechaCaptura     
    */
    public Lectura(String lectura, Date fechaCaptura) {
        this.lectura = lectura;
        this.fechaCaptura = fechaCaptura;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLectura() {
        return lectura;
    }

    public void setLectura(String lectura) {
        this.lectura = lectura;
    }

    public Date getFechaCaptura() {
        return fechaCaptura;
    }

    public void setFechaCaptura(Date fechaCaptura) {
        this.fechaCaptura = fechaCaptura;
    }
}
