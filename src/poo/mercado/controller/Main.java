/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado.controller;

import poo.mercado.controller.GestorAlquilerPuesto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import poo.mercado.Cliente;
import poo.mercado.Contrato;
import poo.mercado.Dimension;
import poo.mercado.Empleado;
import poo.mercado.Estado;
import poo.mercado.Lectura;
import poo.mercado.PrecioAlquiler;
import poo.mercado.Puesto;
import poo.mercado.Sector;
import poo.mercado.Sesion;
import poo.mercado.TipoPuesto;
import poo.mercado.dao.ClientesDao;
import poo.mercado.dao.ClientesDaoHibernateImpl;
import poo.mercado.dao.ClientesDaoImpl;
import poo.mercado.dao.ContratosDao;
import poo.mercado.dao.ContratosDaoHibernateImpl;
import poo.mercado.dao.ContratosDaoImpl;
import poo.mercado.dao.DimensionesDao;
import poo.mercado.dao.DimensionesDaoHibernateImpl;
import poo.mercado.dao.DimensionesDaoImpl;
import poo.mercado.dao.EmpleadosDao;
import poo.mercado.dao.EmpleadosDaoHibernateImpl;
import poo.mercado.dao.EstadosDao;
import poo.mercado.dao.EstadosDaoHibernateImpl;
import poo.mercado.dao.EstadosDaoImpl;
import poo.mercado.dao.PuestosDao;
import poo.mercado.dao.PuestosDaoHibernateImpl;
import poo.mercado.dao.PuestosDaoImpl;
import poo.mercado.dao.SesionesDaoHibernateImpl;
import poo.mercado.dao.TiposPuestoDao;
import poo.mercado.dao.TiposPuestoDaoHibernateImpl;
import poo.mercado.dao.TiposPuestoDaoImpl;

/**
 *
 * @author Candelaria
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        
        // A SessionFactory is set up once for an application!
	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure("resources/hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
			.build();
	try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
	}
	catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
            
            throw e;
	}
        
        Calendar hoy = Calendar.getInstance();
        
        // creamos las instancias de capa DAO
        TiposPuestoDao tiposPuestoDao = new TiposPuestoDaoHibernateImpl(sessionFactory);
        DimensionesDao dimensionesDao = new DimensionesDaoHibernateImpl(sessionFactory);
        EstadosDao estadosDao = new EstadosDaoHibernateImpl(sessionFactory);
        PuestosDao puestosDao = new PuestosDaoHibernateImpl(sessionFactory, estadosDao);
        ClientesDao clientesDao = new ClientesDaoHibernateImpl(sessionFactory);
        ContratosDao contratosDao = new ContratosDaoHibernateImpl(sessionFactory);
        EmpleadosDao empleadosDao = new EmpleadosDaoHibernateImpl(sessionFactory);
        
        // simulamos el inicio de sesion de un empleado
        Empleado marcosSastre = empleadosDao.buscarPorNombreUsuario("msastre");
        Sesion sesion = new Sesion(null, hoy.getTime(), marcosSastre);
        new SesionesDaoHibernateImpl(sessionFactory).guardar(sesion);
        
        // inicializamos el caso de uso
        new GestorAlquilerPuesto(tiposPuestoDao, dimensionesDao, puestosDao, clientesDao, contratosDao, estadosDao, sesion).run();
    }
    
}
