/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
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
import poo.mercado.dao.DimensionesDao;
import poo.mercado.dao.DimensionesDaoHibernateImpl;
import poo.mercado.dao.EmpleadosDao;
import poo.mercado.dao.EmpleadosDaoHibernateImpl;
import poo.mercado.dao.EstadosDao;
import poo.mercado.dao.EstadosDaoHibernateImpl;
import poo.mercado.dao.PuestosDao;
import poo.mercado.dao.PuestosDaoHibernateImpl;
import poo.mercado.dao.SectoresDao;
import poo.mercado.dao.SectoresDaoHibernateImpl;
import poo.mercado.dao.SesionesDaoHibernateImpl;
import poo.mercado.dao.TiposPuestoDao;
import poo.mercado.dao.TiposPuestoDaoHibernateImpl;

/**
 *
 * @author joaquinleonelrobles
 */
public class DatabaseSeeder {
    
    public static void main (String[] args) {
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
        
        Calendar dentroDeSeisMeses = Calendar.getInstance();
        dentroDeSeisMeses.add(Calendar.MONTH, 6);
        
        Calendar haceUnMes = Calendar.getInstance();
        haceUnMes.add(Calendar.MONTH, -1);
        
        Calendar haceSeisMeses = Calendar.getInstance();
        haceSeisMeses.add(Calendar.MONTH, -6);
        
        // creamos los tipos de puesto
        TiposPuestoDao tiposPuestoDao = new TiposPuestoDaoHibernateImpl(sessionFactory);
        
        TipoPuesto techado = new TipoPuesto("Techado", "Con techo de chapa");
        tiposPuestoDao.guardar(techado);
        
        TipoPuesto sinTecho = new TipoPuesto("Sin techo", "Sin techo");
        tiposPuestoDao.guardar(sinTecho);
        
        TipoPuesto refrigerado = new TipoPuesto("Refrigerado", "Con cámara refrigerante");
        tiposPuestoDao.guardar(refrigerado);
        
        // creamos las dimensiones
        DimensionesDao dimensionesDao = new DimensionesDaoHibernateImpl(sessionFactory);
        
        Dimension d10m2 = new Dimension(5, 2, "10");
        dimensionesDao.guardar(d10m2);
        
        Dimension d15m2 = new Dimension(5, 3, "15");
        dimensionesDao.guardar(d15m2);
        
        Dimension d20m2 = new Dimension(5, 4, "20");
        dimensionesDao.guardar(d20m2);
        
        // creamos los sectores
        SectoresDao sectoresDao = new SectoresDaoHibernateImpl(sessionFactory);
        
        Sector alaSur = new Sector("Ala Sur", "Ala Sur");
        sectoresDao.guardar(alaSur);
        
        Sector alaNorte = new Sector("Ala Norte", "Ala Norte");
        sectoresDao.guardar(alaNorte);
        
        // creamos los estados
        EstadosDao estadosDao = new EstadosDaoHibernateImpl(sessionFactory);
        
        Estado disponible = new Estado("Disponible", "Disponible");
        estadosDao.guardar(disponible);
        
        Estado inhabilitado = new Estado("Inhabilitado", "Inhabilitado");
        estadosDao.guardar(inhabilitado);
        
        Estado alquilado = new Estado("Alquilado", "Alquilado");
        estadosDao.guardar(alquilado);
        
        // creamos los empleados
        EmpleadosDao empleadosDao = new EmpleadosDaoHibernateImpl(sessionFactory);
        Empleado marcosSastre = new Empleado("Sastre", 33123123, haceSeisMeses.getTime(), (int) Math.ceil(Math.random() * 1000), "Marcos", "msastre", "asdqwe123");
        empleadosDao.guardar(marcosSastre);
        
        // simulamos el inicio de sesion de un empleado
        Sesion sesion = new Sesion(null, hoy.getTime(), marcosSastre);
        new SesionesDaoHibernateImpl(sessionFactory).guardar(sesion);
        
        // creamos los puestos
        // 1: Ala Sur, 10m2, Techado (DISPONIBLE)
        List<Lectura> lecturasUnoSur10m2Techado = new ArrayList<>();
        lecturasUnoSur10m2Techado.add(new Lectura("56", hoy.getTime()));
        
        List<PrecioAlquiler> preciosUnoSur10m2Techado = new ArrayList<>();
        preciosUnoSur10m2Techado.add(new PrecioAlquiler(haceUnMes.getTime(), new BigDecimal(4500), alaSur, d10m2, techado));
        preciosUnoSur10m2Techado.add(new PrecioAlquiler(dentroDeSeisMeses.getTime(), new BigDecimal(4250), alaSur, d10m2, techado));
        
        Puesto unoSur10m2Techado = new Puesto(1, lecturasUnoSur10m2Techado, disponible, preciosUnoSur10m2Techado);

        // 1: Ala Sur, 20m2, Techado (INHABILITADO)
        List<Lectura> lecturasDosSur10m2Techado = new ArrayList<>();
        lecturasDosSur10m2Techado.add(new Lectura("11", hoy.getTime()));
        
        List<PrecioAlquiler> preciosDosSur10m2Techado = new ArrayList<>();
        preciosDosSur10m2Techado.add(new PrecioAlquiler(haceUnMes.getTime(), new BigDecimal(4500), alaSur, d20m2, techado));
        preciosDosSur10m2Techado.add(new PrecioAlquiler(dentroDeSeisMeses.getTime(), new BigDecimal(4250), alaSur, d20m2, techado));
        
        Puesto dosSur10m2Techado = new Puesto(2, lecturasDosSur10m2Techado, inhabilitado, preciosDosSur10m2Techado);
        
        // 3: Ala Sur, 10m2, Sin Techo (DISPONIBLE)
        List<Lectura> lecturasTresSur10m2SinTecho = new ArrayList<>();
        lecturasTresSur10m2SinTecho.add(new Lectura("45", hoy.getTime()));
        
        List<PrecioAlquiler> preciosTresSur10m2SinTecho = new ArrayList<>();
        preciosTresSur10m2SinTecho.add(new PrecioAlquiler(haceUnMes.getTime(), new BigDecimal(2000), alaSur, d10m2, sinTecho));
        preciosTresSur10m2SinTecho.add(new PrecioAlquiler(dentroDeSeisMeses.getTime(), new BigDecimal(2100), alaSur, d10m2, sinTecho));
        
        Puesto tresSur10m2SinTecho = new Puesto(3, lecturasTresSur10m2SinTecho, disponible, preciosTresSur10m2SinTecho);

        // 4: Ala Norte, 10m2, Techado (ALQUILADO)
        List<Lectura> lecturasCuatroNorte10m2Techado = new ArrayList<>();
        lecturasCuatroNorte10m2Techado.add(new Lectura("37", hoy.getTime()));
        
        List<PrecioAlquiler> preciosCuatroNorte10m2Techado = new ArrayList<>();
        preciosCuatroNorte10m2Techado.add(new PrecioAlquiler(dentroDeSeisMeses.getTime(), new BigDecimal(3700), alaNorte, d10m2, techado));
        
        Puesto cuatroNorte10m2Techado = new Puesto(4, lecturasCuatroNorte10m2Techado, alquilado, preciosCuatroNorte10m2Techado);

        // creamos los puestos
        PuestosDao puestosDao = new PuestosDaoHibernateImpl(sessionFactory, estadosDao);
        puestosDao.guardar(unoSur10m2Techado);
        puestosDao.guardar(dosSur10m2Techado);
        puestosDao.guardar(tresSur10m2SinTecho);
        puestosDao.guardar(cuatroNorte10m2Techado);
        
        // creamos los contratos
        Contrato contratoPuestoCuatro = new Contrato(null, dentroDeSeisMeses.getTime(), haceUnMes.getTime(), new BigDecimal(3700), 1, marcosSastre, sesion, cuatroNorte10m2Techado, null);
        
        // creamos los clientes
        ClientesDao clientesDao = new ClientesDaoHibernateImpl(sessionFactory);
        
        List<Contrato> contratosDeRosa = new ArrayList<>();
        contratosDeRosa.add(contratoPuestoCuatro);
        clientesDao.guardar(new Cliente(20343434345l, "Av Siempreviva 123", "Rosa Fernández", contratosDeRosa));
    }
    
}
