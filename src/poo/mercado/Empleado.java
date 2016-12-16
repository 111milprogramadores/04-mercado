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
public class Empleado {
    private String apellido;
    private int dni;
    private Date fechaIngreso;
    private int legajo;
    private String nombre;
    private String nombreUsuario;
    private String password;

    /**
    * Constructor por Defecto
    */
    public Empleado() {
    }

    /**
    * Constructor con parámetros.
     * @param apellido
     * @param dni
     * @param fechaIngreso
     * @param legajo
     * @param nombre
     * @param nombreUsuario
     * @param password
    */
    public Empleado(String apellido, int dni, Date fechaIngreso, int legajo, String nombre, String nombreUsuario, String password) {
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.legajo = legajo;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
