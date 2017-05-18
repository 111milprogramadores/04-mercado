/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import poo.mercado.Dimension;

/**
 *
 * @author joaquinleonelrobles
 */
public class DimensionesDaoHibernateImpl implements DimensionesDao {
    
    private SessionFactory sessionFactory;

    public DimensionesDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardar(Dimension dimension) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(dimension);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Dimension> obtenerTodas() {
        Session session = sessionFactory.openSession();
        List<Dimension> retorno = session.createQuery("from Dimension").list();
        session.close();
        
        return retorno;
    }
    
}
