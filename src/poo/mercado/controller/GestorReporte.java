/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado.controller;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import poo.mercado.Estado;
import poo.mercado.TipoPuesto;
import poo.mercado.dao.EstadosDao;
import poo.mercado.dao.EstadosDaoHibernateImpl;
import poo.mercado.dao.TiposPuestoDao;
import poo.mercado.dao.TiposPuestoDaoHibernateImpl;
import poo.mercado.ui.PantallaGenerarReporte;

/**
 *
 * @author joaquinleonelrobles
 */
public class GestorReporte {
    
    private PantallaGenerarReporte pantalla;
    
    private final TiposPuestoDao tiposPuestoDao;
    private final EstadosDao estadosDao;
    
    private final SessionFactory sessionFactory;

    public GestorReporte (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        
        // creamos las intancias de la capa DAO
        this.tiposPuestoDao = new TiposPuestoDaoHibernateImpl(sessionFactory);
        this.estadosDao = new EstadosDaoHibernateImpl(sessionFactory);
    }
    
    public void run () {
        this.pantalla = new PantallaGenerarReporte(tiposPuestoDao.obtenerTodos(), estadosDao.obtenerTodos(), this);
        this.pantalla.setVisible(true);
    }

    /**
     * Generamos un reporte en pantalla usando la librería de JasperReports,
     * recibimos como entrada los valores ingresados en pantalla y compilamos
     * el reporte en formato XML para mostrarlo con el componente visual
     * JasperViewer.
     * 
     * @param tiposPuesto
     * @param estados
     */
    public void generarReporte(List<TipoPuesto> tiposPuesto, List<Estado> estados) {
        System.out.println("Tipos: " + tiposPuesto);
        System.out.println("Estados: " + estados);
        
        // abrimos una sesion de hibernate
        Session session = sessionFactory.openSession();
        
        // creamos las listas de IDs para incluir en la consulta SQL del reporte
        List<Integer> idsTiposPuesto = obtenerListaDeIdsTiposPuesto(tiposPuesto);
        List<Integer> idsEstados = obtenerListaDeIdsEstados(estados);

        // utilizamos la sesion de hibernate para acceder a la conexion JDBC
        session.doWork(new Work() {
            @Override
            public void execute(Connection conexion) throws SQLException {
                try {
                    // armamos el modelo de parametros
                    Map<String, Object> parametros = new HashMap<>();
                    parametros.put("idsTiposPuesto", idsTiposPuesto);
                    parametros.put("idsEstados", idsEstados);

                    // creamos el reporte
                    InputStream design = getClass().getResourceAsStream("/resources/reportes/puestos-por-estado.jrxml");
                    JasperDesign jasperDesing = JRXmlLoader.load(design);
                    JasperReport reporte = JasperCompileManager.compileReport(jasperDesing);

                    // imprimimos el reporte con los parametros
                    JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, conexion);

                    // visualizamos el reporte en pantalla
                    JasperViewer.viewReport(jasperPrint, false);
                }
                catch (JRException ex) {
                    System.out.println("Error al generar el reporte: " + ex.getMessage());
                }
            }
        });

        // cerramos la sesion
        session.close();
    }

    private List<Integer> obtenerListaDeIdsTiposPuesto(List<TipoPuesto> tiposPuesto) {
        List<Integer> ids = new ArrayList<>();
        
        for (TipoPuesto tipo : tiposPuesto) ids.add(tipo.getId());
        
        return ids;
    }

    private List<Integer> obtenerListaDeIdsEstados(List<Estado> estados) {
        List<Integer> ids = new ArrayList<>();
        
        for (Estado estado : estados) ids.add(estado.getId());
        
        return ids;
    }
    
}
