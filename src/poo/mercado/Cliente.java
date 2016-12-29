/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Candelaria
 */
public class Cliente {
    private long cuit;
    private String domicilio;
    private String razonSocial;
    private List<Contrato> contratos;

    /**
    * Constructor por Defecto.
    */
    public Cliente() {
        contratos = new ArrayList<>();
    }

    /**
    * Constructor con parámetros, sin incluir atributos referenciales.
     * @param cuit     
     * @param domicilio     
     * @param razonSocial     
    */
    public Cliente(long cuit, String domicilio, String razonSocial) {
        this.cuit = cuit;
        this.domicilio = domicilio;
        this.razonSocial = razonSocial;
    }

    /**
    * Constructor con parámetros, con todos los atributos de la clase Cliente.
     * @param cuit     
     * @param domicilio     
     * @param razonSocial  
     * @param contratos  
    */
    public Cliente(long cuit, String domicilio, String razonSocial, List<Contrato> contratos) {
        this.cuit = cuit;
        this.domicilio = domicilio;
        this.razonSocial = razonSocial;
        this.contratos = contratos;
    }

    public long getCuit() {
        return cuit;
    }

    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }

    public Contrato crearContrato(Puesto puesto, Date fechaDesde, Date fechaHasta, Sesion sesion, int numero) {
        // creamos el nuevo objeto
        Contrato contrato = new Contrato(null, fechaHasta, fechaDesde, puesto.obtenerPrecioVigente().getPrecio(), numero, sesion.getEmpleado(), sesion, puesto, puesto.obtenerUltimaLectura());
        
        // lo agregamos a la coleccion
        contratos.add(contrato);
        
        // y lo devolvemos
        return contrato;
    }
    
}
