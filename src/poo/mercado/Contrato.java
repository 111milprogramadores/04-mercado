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
public class Contrato {
    private Date fechaCancelacion;
    private Date fechaFinContrato;
    private Date fechaInicioContrato;
    private BigDecimal montoMensual;
    private int numero;
    private Empleado responsableMercado;
    private Sesion registro;
    private Puesto puesto;
    private Lectura ultimaLecturaMedidor;
    

    /**
    * Constructor por Defecto
    */
    public Contrato() {
    }

    /**
    * Constructor con parámetros, sin incluir atributos referenciales.
     *@param fechaCancelacion
     * @param fechaFinContrato
     * @param fechaInicioContrato
     * @param montoMensual
     * @param numero
    */
    public Contrato(Date fechaCancelacion, Date fechaFinContrato, Date fechaInicioContrato, BigDecimal montoMensual, int numero) {
        this.fechaCancelacion = fechaCancelacion;
        this.fechaFinContrato = fechaFinContrato;
        this.fechaInicioContrato = fechaInicioContrato;
        this.montoMensual = montoMensual;
        this.numero = numero;
    }

    /**
    * Constructor con parámetros,con todos los atributos de la clase Contrato.
     * @param fechaCancelacion
     * @param fechaFinContrato
     * @param fechaInicioContrato
     * @param montoMensual
     * @param numero
     * @param responsableMercado
     * @param registro
     * @param puesto
     * @param ultimaLecturaMedidor
    */
    public Contrato(Date fechaCancelacion, Date fechaFinContrato, Date fechaInicioContrato, BigDecimal montoMensual, int numero, Empleado responsableMercado, Sesion registro, Puesto puesto, Lectura ultimaLecturaMedidor) {
        this.fechaCancelacion = fechaCancelacion;
        this.fechaFinContrato = fechaFinContrato;
        this.fechaInicioContrato = fechaInicioContrato;
        this.montoMensual = montoMensual;
        this.numero = numero;
        this.responsableMercado = responsableMercado;
        this.registro = registro;
        this.puesto = puesto;
        this.ultimaLecturaMedidor = ultimaLecturaMedidor;
    }

    
    public Date getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(Date fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    public Date getFechaFinContrato() {
        return fechaFinContrato;
    }

    public void setFechaFinContrato(Date fechaFinContrato) {
        this.fechaFinContrato = fechaFinContrato;
    }

    public Date getFechaInicioContrato() {
        return fechaInicioContrato;
    }

    public void setFechaInicioContrato(Date fechaInicioContrato) {
        this.fechaInicioContrato = fechaInicioContrato;
    }

    public BigDecimal getMontoMensual() {
        return montoMensual;
    }

    public void setMontoMensual(BigDecimal montoMensual) {
        this.montoMensual = montoMensual;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Empleado getResponsableMercado() {
        return responsableMercado;
    }

    public void setResponsableMercado(Empleado responsableMercado) {
        this.responsableMercado = responsableMercado;
    }

    public Sesion getRegistro() {
        return registro;
    }

    public void setRegistro(Sesion registro) {
        this.registro = registro;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public Lectura getUltimaLecturaMedidor() {
        return ultimaLecturaMedidor;
    }

    public void setUltimaLecturaMedidor(Lectura ultimaLecturaMedidor) {
        this.ultimaLecturaMedidor = ultimaLecturaMedidor;
    }
           
}
