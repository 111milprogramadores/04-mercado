/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import poo.mercado.TipoPuesto;

/**
 *
 * @author joaquinleonelrobles
 */
public class TiposPuestoDaoHibernateImpl implements TiposPuestoDao {
    
    private SessionFactory sessionFactory;

    public TiposPuestoDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardar(TipoPuesto tipoPuesto) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(tipoPuesto);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<TipoPuesto> obtenerTodos() {
        Session session = sessionFactory.openSession();
        List<TipoPuesto> retorno = session.createQuery("from TipoPuesto").list();
        session.close();
        
        return retorno;
    }
    
}
