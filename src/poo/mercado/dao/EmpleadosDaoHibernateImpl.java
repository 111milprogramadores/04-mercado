/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import poo.mercado.Empleado;

/**
 *
 * @author joaquinleonelrobles
 */
public class EmpleadosDaoHibernateImpl implements EmpleadosDao {
    
    private SessionFactory sessionFactory;

    public EmpleadosDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardar(Empleado empleado) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(empleado);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Empleado buscarPorNombreUsuario(String nombreUsuario) {
        Session session = sessionFactory.openSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Empleado> query = builder.createQuery(Empleado.class);
        Root<Empleado> root = query.from(Empleado.class);
        query.select(root);
        query.where(builder.equal(root.get("nombreUsuario"), nombreUsuario));
        
        Empleado empleado = session.createQuery(query).uniqueResult();
        
        session.close();
        
        return empleado;
    }
    
}
