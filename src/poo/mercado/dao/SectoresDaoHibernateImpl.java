/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import poo.mercado.Puesto;
import poo.mercado.Sector;

/**
 *
 * @author joaquinleonelrobles
 */
public class SectoresDaoHibernateImpl implements SectoresDao {
    
    private SessionFactory sessionFactory;

    public SectoresDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardar(Sector sector) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(sector);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Sector buscarPorNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
