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
public class Sesion {
    private Date fechaHoraFin;
    private Date fechaHoraInicio;
    private Empleado empleado;

    /**
    * Constructor por Defecto
    */
    public Sesion() {
    }

    /**
    * Constructor con parámetro, con todos los atributos de la clase Sesion.
    * @param fechaHoraFin
    * @param fechaHoraInicio
    * @param empleado
    */
    public Sesion(Date fechaHoraFin, Date fechaHoraInicio, Empleado empleado) {
        this.fechaHoraFin = fechaHoraFin;
        this.fechaHoraInicio = fechaHoraInicio;
        this.empleado = empleado;
    }

    public Date getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(Date fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public Date getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(Date fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
}
