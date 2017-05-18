/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import poo.mercado.Sesion;

/**
 *
 * @author joaquinleonelrobles
 */
public class SesionesDaoHibernateImpl implements SesionesDao {
    
    private SessionFactory sessionFactory;

    public SesionesDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardar(Sesion sesion) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(sesion);
        session.getTransaction().commit();
        session.close();
    }
}
