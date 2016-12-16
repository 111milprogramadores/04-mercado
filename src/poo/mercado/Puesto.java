/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Candelaria
 */
public class Puesto {
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
    
}
