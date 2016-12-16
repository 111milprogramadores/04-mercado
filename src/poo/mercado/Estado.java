/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado;

/**
 *
 * @author Candelaria
 */
public class Estado {
    private String descripcion;
    private String nombre;

    /**
    * Constructor por Defecto
    */
    public Estado() {
    }

    /**
    * Constructor con parámetros.
     * @param nombre
     * @param descripcion
    */
    public Estado(String descripcion, String nombre) {
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
